import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSauceDemo {
    WebDriver driver;
    StartPageSauceDemo startPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        startPage = new StartPageSauceDemo(driver);
    }

    @Test
    public void nocorrectLog() {
        startPage.openSite();
        startPage.logIn("Test", "secret_sauce");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Ошибка");
    }

    @Test
    public void nocorrectPass() {
        startPage.openSite();
        startPage.logIn("standard_user", "Test");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Ошибка");
    }

    @Test
    public void nocorrectPassbadExpected() {
        startPage.openSite();
        startPage.logIn("standard_user", "Test");
        assertEquals(startPage.getErrorMessage(), "Test text", "Ошибка");
    }
    @Test
    public void cleanLogandPass() {
        startPage.openSite();
        startPage.logIn("", "");
        assertEquals(startPage.getErrorMessage(), "Epic sadface: Username is required", "Ошибка");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}