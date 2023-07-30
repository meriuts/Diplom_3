package site.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordRecoveryPage {
    WebDriver driver;
    private final By buttonEnterPasswordRecovery = By.xpath(".//a[text() = 'Войти']");

    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getButtonEnterPasswordRecoveryElement() {
        return driver.findElement(buttonEnterPasswordRecovery);
    }
}
