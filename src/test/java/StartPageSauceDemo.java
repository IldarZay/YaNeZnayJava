import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPageSauceDemo {
    WebDriver runMethodWebdriver;
    private final By Username = By.id("user-name");
    private final By Password = By.id("password");
    private final By Button_Click = By.id("login-button");

    public StartPageSauceDemo(WebDriver runMethodWebdriver) {
        this.runMethodWebdriver = runMethodWebdriver;
    }

    public void openSite() {
        runMethodWebdriver.get("https://www.saucedemo.com/");
    }

    // Method to log in
    public void logIn(String user, String password) {
        runMethodWebdriver.findElement(Username).sendKeys(user);
        runMethodWebdriver.findElement(Password).sendKeys(password);
        runMethodWebdriver.findElement(Button_Click).click();
    }
}
