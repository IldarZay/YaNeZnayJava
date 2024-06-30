import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageSauceDemo {
    private WebDriver driver;
    private By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private By cartItems = By.cssSelector(".cart_item");

    public CartPageSauceDemo(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }
}