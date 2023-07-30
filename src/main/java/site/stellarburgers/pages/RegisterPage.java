package site.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;
    private final By nameRegister = By.xpath(".//div/label[text() = 'Имя']/following-sibling::input");
    private final By emailRegister = By.xpath(".//div/label[text() = 'Email']/following-sibling::input");
    private final By passwordRegister = By.xpath(".//div/label[text() = 'Пароль']/following-sibling::input");
    private final By buttonRegister = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By errorTextWrongPassword = By.xpath(".//p[text() = 'Некорректный пароль']");
    private final By buttonEnterFromRegisterPage = By.xpath(".//a[text() = 'Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameRegisterElement() {
        return driver.findElement(nameRegister);
    }
    public WebElement getEmailRegisterElement() {
        return driver.findElement(emailRegister);
    }
    public WebElement getPasswordRegisterElement() {
        return driver.findElement(passwordRegister);
    }
    public WebElement getButtonRegisterElement() {
        return driver.findElement(buttonRegister);
    }

    public WebElement getErrorTextWrongPasswordElement() {
        return driver.findElement(errorTextWrongPassword);
    }

    public WebElement getButtonEnterFromRegisterPageElement() {
        return driver.findElement(buttonEnterFromRegisterPage);
    }
    @Step("Создать нового пользователя")
    public void registerUser(String nameRegister, String emailRegister, String passwordRegister){
        getNameRegisterElement().sendKeys(nameRegister);
        getEmailRegisterElement().sendKeys(emailRegister);
        getPasswordRegisterElement().sendKeys(passwordRegister);
        getButtonRegisterElement().click();
    }


}
