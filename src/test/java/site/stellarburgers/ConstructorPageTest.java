package site.stellarburgers;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site.stellarburgers.pages.ConstructorPage;

import static site.stellarburgers.config.AppConfig.BASE_PAGE_URL;

public class ConstructorPageTest extends BaseTest {

    @BeforeEach
    public void open(){
        driver.get(BASE_PAGE_URL);
    }

    @Test
    @Description("Переход на раздел Соусы")
    public void userCanSwitchBurgerConstructionSection_Sauce(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(constructorPage.getUnselectedTabSauceElement()));

        constructorPage.getUnselectedTabSauceElement().click();

        Assertions.assertNotNull(constructorPage.getSelectedTabSauceElement());
        Assertions.assertNotNull(constructorPage.getUnselectedTabBunElement());
        Assertions.assertNotNull(constructorPage.getUnSelectedFillingsElement());
    }

    @Test
    @Description("Переход на раздел Начинки")
    public void userCanSwitchBurgerConstructionSection_Fillings(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(constructorPage.getUnSelectedFillingsElement()));

        constructorPage.getUnSelectedFillingsElement().click();

        Assertions.assertNotNull(constructorPage.getSelectedFillingsElement());
        Assertions.assertNotNull(constructorPage.getUnselectedTabBunElement());
        Assertions.assertNotNull(constructorPage.getUnselectedTabSauceElement());
    }

    @Test
    @Description("Переход на раздел Булки")
    public void userCanSwitchBurgerConstructionSection_Bun(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(constructorPage.getUnselectedTabSauceElement()));

        constructorPage.getUnselectedTabSauceElement().click();
        constructorPage.getUnselectedTabBunElement();

        Assertions.assertNotNull(constructorPage.getSelectedTabBunElement());
        Assertions.assertNotNull(constructorPage.getUnselectedTabSauceElement());
        Assertions.assertNotNull(constructorPage.getUnSelectedFillingsElement());
    }

}
