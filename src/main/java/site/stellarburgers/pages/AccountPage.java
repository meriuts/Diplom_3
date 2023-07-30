package site.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private WebDriver driver;
    private String userName;

    private final By buttonProfileAccount = By.xpath(".//a[text() = 'Профиль']");
    private final By buttonLogoutAccount = By.xpath(".//button[text() = 'Выход']");

    private final By nameUserAccount = By.xpath(String.format(".//input[@disabled value  = '%s']", userName));

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getNameUserAccountElement() {
        return driver.findElement(nameUserAccount);
    }

    public WebElement getButtonProfileAccountElement() {
        return driver.findElement(buttonProfileAccount);
    }

    public WebElement getButtonLogoutAccountElement() {
        return driver.findElement(buttonLogoutAccount);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
