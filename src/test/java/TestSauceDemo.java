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

@Epic("Тесты SauceDemo")
@Feature("Вход")
public class TestSauceDemo {
    WebDriver driver;
    StartPageSauceDemo startPage;
    CartPageSauceDemo cartPage;

    @BeforeClass
    @Step("Инициализация драйвера")
    public void setUp() {
        driver = new ChromeDriver();
        startPage = new StartPageSauceDemo(driver);
        cartPage = new CartPageSauceDemo(driver);
    }

    @Test
    @Description("Негативная проверка логина с неверным именем пользователя")
    public void incorrectLogin() {
        startPage.openSite();
        startPage.logIn("Test", "secret_sauce");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Ошибка");
    }

    @Test
    @Description("Негативная проверка логина с неверным паролем")
    public void incorrectPassword() {
        startPage.openSite();
        startPage.logIn("standard_user", "Test");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Ошибка");
    }

    @Test
    @Description("Проверка с неверным ожидаемым текстом сообщения об ошибке")
    public void incorrectExpectedErrorMessage() {
        startPage.openSite();
        startPage.logIn("standard_user", "Test");
        assertEquals(startPage.getErrorMessage(), "Test text", "Ошибка");
    }

    @Test
    @Description("Проверка логина с пустым именем пользователя и паролем")
    public void emptyUsernameAndPassword() {
        startPage.openSite();
        startPage.logIn("", "");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username is required", "Ошибка");
    }

    @Test
    @Description("Проверка добавления товара в корзину")
    public void testAddItemToCart() {
        startPage.openSite();
        startPage.logIn("standard_user", "secret_sauce");

        startPage.clickAddToCartButton();

        startPage.openCart();

        assertEquals(cartPage.getCartItemsCount(), 1, "Товар не был добавлен в корзину");
        assertEquals(cartPage.getCartBadgeText(), "1", "Значок корзины не показывает правильное количество товаров");
    }

    @AfterClass
    @Step("Закрытие")
    public void tearDown() {
        driver.quit();
    }
}