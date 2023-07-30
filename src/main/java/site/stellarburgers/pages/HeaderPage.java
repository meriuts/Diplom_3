package site.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage {
    WebDriver driver;
    private final By buttonConstructor = By.xpath(".//a/p[text() = 'Конструктор']");
    private final By logo = By.xpath(".//a[@href = '/']");
    private final By buttonAccount = By.xpath(".//nav/a/p[text() = 'Личный Кабинет']");


    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonConstructorElement() {
        return driver.findElement(buttonConstructor);
    }

    public WebElement getLogoElement() {
        return driver.findElement(logo);
    }
    public WebElement getButtonAccountElement() {
        return driver.findElement(buttonAccount);
    }


}
