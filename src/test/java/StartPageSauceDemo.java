import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPageSauceDemo {
    WebDriver driver;
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By addToCartButton = By.cssSelector(".btn_inventory");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public StartPageSauceDemo(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get("https://www.saucedemo.com/");
    }

    public void logIn(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector("[data-test='error']")).getText();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }
}