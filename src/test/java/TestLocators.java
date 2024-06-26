import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestLocators {

    @Test
    public void insiteLocators(){
        // Я не понял почему оно из коробки работает без хромдрайвера в ресурсах
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.name("user-name")).sendKeys("standard_user");
        browser.findElement(By.name("password")).sendKeys("secret_sauce");
        browser.findElement(By.id("login-button")).click();
       // Ура авторизация прошла, сейчас искать локаторы
        browser.findElement(By.id("contents_wrapper"));
        browser.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
        browser.findElement(By.className("inventory_container"));
        browser.findElements(By.tagName("a"));
        browser.findElement(By.linkText("Sauce Labs Bike Light"));
        browser.findElements(By.partialLinkText("Fleece Jacket"));
        browser.findElement(By.xpath("//a[@data-test='item-4-img-link']"));
        browser.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
        browser.findElement(By.xpath("//div[contains(text(),'Red')]"));
        browser.findElement(By.xpath("//a[contains(@id,'about_sidebar')]"));
        browser.findElement(By.xpath("//*[contains(text(),'Sauce Labs')]//ancestor::a"));
        browser.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']/preceding::div[contains(text(),'$')]"));
        browser.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-onesie']/following::div[contains(text(),'$')]"));
        browser.findElement(By.xpath("//div[@class='inventory_item']/descendant::a[@id='item_3_title_link']"));
        browser.findElement(By.xpath("//a[@class='inventory_list' or @id='item_2_title_link']"));
        browser.findElement(By.cssSelector(".active_option"));
        browser.findElement(By.cssSelector(".btn.btn_primary"));
        browser.findElement(By.cssSelector("#inventory_sidebar_link"));
        browser.findElement(By.cssSelector("a[data-test='item-3-title-link']"));
        browser.findElement(By.cssSelector("div[data-test='header-container'] .shopping_cart_link"));
browser.quit();
    }
}
