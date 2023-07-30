package site.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage {
    WebDriver driver;
    private final By emailLogin = By.xpath(".//div/label[text() = 'Email']/following-sibling::input");
    private final By passwordLogin  = By.xpath(".//div/label[text() = 'Пароль']/following-sibling::input");
    private final By buttonLogin = By.xpath(".//button[text() = 'Войти']");
    private final By buttonRegisterFromLoginPage = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private final By buttonPasswordRecoveryFromLoginPage = By.xpath(".//a[text() = 'Восстановить пароль']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonLoginElement() {
        return driver.findElement(buttonLogin);
    }

    public WebElement getEmailLoginElement() {
        return driver.findElement(emailLogin);
    }

    public WebElement getPasswordLoginElement() {
        return driver.findElement(passwordLogin);
    }

    public WebElement getButtonRegisterFromLoginPageElement() {
        return driver.findElement(buttonRegisterFromLoginPage);
    }

    public WebElement getButtonPasswordRecoveryFromLoginPageElement() {
        return driver.findElement(buttonPasswordRecoveryFromLoginPage);
    }

    @Step("Залогинить пользователя")
    public void userLogin(String userEmailLogin, String userPasswordLogin) {
        driver.findElement(emailLogin).sendKeys(userEmailLogin);
        driver.findElement(passwordLogin).sendKeys(userPasswordLogin);
        driver.findElement(buttonLogin).click();
    }




}
