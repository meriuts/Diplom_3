package site.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorPage {
    WebDriver driver;
    private final By buttonEnterAccount = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private final By buttonMakeOrder = By.xpath(".//button[text() = 'Оформить заказ']");
    private final By selectedTabBun = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Булки']");
    private final By selectedTabSauce = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");
    private final By selectedFillings = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");

    private final By unselectedTabBun = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Булки']");
    private final By unselectedTabSauce = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");
    private final By unselectedFillings = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");


    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonEnterAccountElement() {
        return driver.findElement(buttonEnterAccount);
    }
    public WebElement getButtonMakeOrderElement() {
        return driver.findElement(buttonMakeOrder);
    }
    public WebElement getSelectedTabBunElement() {
        return driver.findElement(selectedTabBun);
    }

    public WebElement getSelectedTabSauceElement() {
        return driver.findElement(selectedTabSauce);
    }

    public WebElement getSelectedFillingsElement() {
        return driver.findElement(selectedFillings);
    }

    public WebElement getUnselectedTabBunElement() {
        return driver.findElement(unselectedTabBun);
    }

    public WebElement getUnselectedTabSauceElement() {
        return driver.findElement(unselectedTabSauce);
    }

    public WebElement getUnSelectedFillingsElement() {
        return driver.findElement(unselectedFillings);
    }

}
