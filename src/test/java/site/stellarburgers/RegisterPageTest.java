package site.stellarburgers;

import io.qameta.allure.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import site.stellarburgers.pages.LoginPage;
import site.stellarburgers.pages.RegisterPage;
import site.stellarburgers.steps.delete.DeleteUser;
import site.stellarburgers.steps.login.LoginRequestBody;
import site.stellarburgers.steps.login.LoginUser;
import site.stellarburgers.steps.login.response.LoginResponseBody;

import static site.stellarburgers.config.AppConfig.REGISTER_PAGE_URL;

public class RegisterPageTest extends BaseTest {
    private RegisterPage registerPage;
    @BeforeEach
    public void open(){
        driver.get(REGISTER_PAGE_URL);
        registerPage = new RegisterPage(driver);

    }
    @Test
    @Description("Регистрация нового пользователя")
    public void userCanRegister(){
        registerPage.getNameRegisterElement().sendKeys(name);
        registerPage.getEmailRegisterElement().sendKeys(email);
        registerPage.getPasswordRegisterElement().sendKeys(password);
        registerPage.getButtonRegisterElement().click();

        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertNotNull(loginPage.getButtonLoginElement());

        loginUser = new LoginUser();
        loginRequestBody = new LoginRequestBody(email, password);
        loginResponseBody = loginUser.loginNewUser(loginRequestBody).as(LoginResponseBody.class);
        String accessToken = loginResponseBody.getAccessToken();

        deleteUser = new DeleteUser();
        deleteUser.deleteUser(accessToken);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    @Description("Валидация пароля при регистрации")
    public void userCannotRegisterWrongPassword(String password){
        registerPage.getNameRegisterElement().sendKeys(name);
        registerPage.getEmailRegisterElement().sendKeys(email);
        registerPage.getPasswordRegisterElement().sendKeys(password);
        registerPage.getButtonRegisterElement().click();

        Assertions.assertNotNull(registerPage.getErrorTextWrongPasswordElement());
    }
}
