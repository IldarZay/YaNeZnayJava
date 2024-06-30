import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Epic("SauceDemo тесты")
@Feature("Вход")
public class TestSauceDemo {
    WebDriver driver;
    StartPageSauceDemo startPage;

    @BeforeClass
    @Step("Инициализация драйвера")
    public void setUp() {
        driver = new ChromeDriver();
        startPage = new StartPageSauceDemo(driver);
    }

    @Test
    @Description("Негативная проверка логин")
    public void nocorrectLog() {
        startPage.openSite();
        startPage.logIn("Test", "secret_sauce");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Ошибка");
    }

    @Test
    @Description("Негативная проверка пароль")
    public void nocorrectPass() {
        startPage.openSite();
        startPage.logIn("standard_user", "Test");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Ошибка");
    }

    @Test
    @Description("Проверка если в самом тесте неверно указан текст")
    public void nocorrectPassbadExpected() {
        startPage.openSite();
        startPage.logIn("standard_user", "Test");
        assertEquals(startPage.getErrorMessage(), "Test text", "Ошибка");
    }

    @Test
    @Description("Проверка на пустой логин пароль")
    public void cleanLogandPass() {
        startPage.openSite();
        startPage.logIn("", "");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username is required", "Ошибка");
    }

    @AfterClass
    @Step("Закрытие")
    public void tearDown() {
        driver.quit();
    }
}