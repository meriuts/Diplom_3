package site.stellarburgers;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.stellarburgers.driver.DriverFactory;
import site.stellarburgers.steps.delete.DeleteUser;
import site.stellarburgers.steps.login.LoginRequestBody;
import site.stellarburgers.steps.login.response.LoginResponseBody;
import site.stellarburgers.steps.login.LoginUser;

import java.time.Duration;
import java.util.Locale;

public class BaseTest {
    String browserYandex = "yandex";
    String browserChrome = "chrome";
    WebDriver driver;
    WebDriverWait wait;
    LoginUser loginUser;
    LoginRequestBody loginRequestBody;
    LoginResponseBody loginResponseBody;
    DeleteUser deleteUser;
    Faker faker;
    FakeValuesService fakeValuesService;
    String name;
    String email;
    String password;

    @BeforeEach
    public void setUp(){
        driver = DriverFactory.setDriver(browserChrome);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        faker = new Faker();
        fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());

        name = faker.name().firstName();
        email = fakeValuesService.bothify("?????##@gmail.com");
        password = fakeValuesService.bothify("###???");

    }

    @AfterEach
    public void closeBrowser (){
        driver.quit();
    }
}
