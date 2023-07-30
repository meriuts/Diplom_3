package site.stellarburgers;

import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site.stellarburgers.pages.*;
import site.stellarburgers.steps.delete.DeleteUser;
import site.stellarburgers.steps.login.LoginRequestBody;
import site.stellarburgers.steps.login.LoginUser;
import site.stellarburgers.steps.login.response.LoginResponseBody;
import site.stellarburgers.steps.register.RegisterBody;
import site.stellarburgers.steps.register.RegisterUser;
import static site.stellarburgers.config.AppConfig.LOGIN_PAGE_URL;


public class AccountPageTest extends BaseTest {

    @BeforeEach
    public void loginInApp(){
        driver.get(LOGIN_PAGE_URL);

        RegisterUser registerUser = new RegisterUser();
        RegisterBody registerBody = new RegisterBody(email, password, name);
        registerUser.registerNewUser(registerBody);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin(email, password);

    }
    @AfterEach
    public void deleteUser() {
        loginUser = new LoginUser();
        loginRequestBody = new LoginRequestBody(email, password);
        loginResponseBody = loginUser.loginNewUser(loginRequestBody).as(LoginResponseBody.class);
        String accessToken = loginResponseBody.getAccessToken();

        deleteUser = new DeleteUser();
        deleteUser.deleteUser(accessToken);
    }

    @Test
    @Description("Переход в ЛК через кнопку Личный кабинет")
    public void userCanSwitchToAccount_ClickOnAccount(){
        HeaderPage headerPage = new HeaderPage(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(headerPage.getButtonAccountElement()));
        headerPage.getButtonAccountElement().click();

        AccountPage accountPage = new AccountPage(driver);
        Assertions.assertNotNull(accountPage.getButtonProfileAccountElement());
    }
    @Test
    @Description("Переход из ЛК в Конструктуор через кнопку Конструктор")
    public void userCanSwitchFromAccountToConstructor_ClickOnConstructor(){
        HeaderPage headerPage = new HeaderPage(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(headerPage.getButtonAccountElement()));
        headerPage.getButtonAccountElement().click();
        headerPage.getButtonConstructorElement().click();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        Assertions.assertNotNull(constructorPage.getButtonMakeOrderElement());
    }
    @Test
    @Description("Переход из ЛК в Конструктуор через логотип")
    public void userCanSwitchFromAccountToConstructor_ClickOnLogo(){
        HeaderPage headerPage = new HeaderPage(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(headerPage.getButtonAccountElement()));
        headerPage.getButtonAccountElement().click();
        headerPage.getLogoElement().click();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        Assertions.assertNotNull(constructorPage.getButtonMakeOrderElement());
    }
    @Test
    @Description("Выход из аккаунта")
    public void userCanLogout(){
        HeaderPage headerPage = new HeaderPage(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(headerPage.getButtonAccountElement()));
        headerPage.getButtonAccountElement().click();

        AccountPage accountPage = new AccountPage(driver);
        wait.until(ExpectedConditions.visibilityOf(accountPage.getButtonLogoutAccountElement()));
        accountPage.getButtonLogoutAccountElement().click();

        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertNotNull(loginPage.getButtonLoginElement());
    }

}
