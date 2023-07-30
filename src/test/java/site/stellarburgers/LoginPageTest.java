package site.stellarburgers;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import site.stellarburgers.pages.*;
import site.stellarburgers.steps.delete.DeleteUser;
import site.stellarburgers.steps.login.LoginRequestBody;
import site.stellarburgers.steps.login.LoginUser;
import site.stellarburgers.steps.login.response.LoginResponseBody;
import site.stellarburgers.steps.register.RegisterBody;
import site.stellarburgers.steps.register.RegisterUser;

import static site.stellarburgers.config.AppConfig.BASE_PAGE_URL;


public class LoginPageTest extends BaseTest {

    @BeforeEach
    public void registerNewUserForTest(){
        driver.get(BASE_PAGE_URL);

        RegisterUser  registerUser = new RegisterUser();
        RegisterBody registerBody = new RegisterBody(email, password, name);
        registerUser.registerNewUser(registerBody);
    }

    @AfterEach
    public void deleteUser (){
        loginUser = new LoginUser();
        loginRequestBody = new LoginRequestBody(email, password);
        loginResponseBody = loginUser.loginNewUser(loginRequestBody).as(LoginResponseBody.class);
        String accessToken = loginResponseBody.getAccessToken();

        deleteUser = new DeleteUser();
        deleteUser.deleteUser(accessToken);
    }

    @Test
    @Description("Вход по кнопке Войти в аккаунт")
    public void userCanLoginFromConstructorPage(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.getButtonEnterAccountElement().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(email, password);

        Assertions.assertNotNull(constructorPage.getButtonMakeOrderElement());
    }


    @Test
    @Description("Вход через кнопку Личный кабинет")
    public void userCanLoginFromAccount(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.getButtonAccountElement().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        Assertions.assertNotNull(constructorPage.getButtonMakeOrderElement());
    }

    @Test
    @Description("Вход через кнопку в форме регистрации")
    public void userCanLoginFromEnterButtonRegisterForm(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.getButtonAccountElement().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getButtonRegisterFromLoginPageElement().click();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getButtonEnterFromRegisterPageElement().click();

        loginPage.userLogin(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        Assertions.assertNotNull(constructorPage.getButtonMakeOrderElement());
    }

    @Test
    @Description("Вход через кнопку в форме восстановления пароля")
    public void userCanLoginFromButtonPasswordRecoveryFromAccountPage(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.getButtonAccountElement().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getButtonPasswordRecoveryFromLoginPageElement().click();

        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.getButtonEnterPasswordRecoveryElement().click();

        loginPage.userLogin(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        Assertions.assertNotNull(constructorPage.getButtonMakeOrderElement());
    }
}
