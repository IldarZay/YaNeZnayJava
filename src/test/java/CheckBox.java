import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBox {

    public void checkBoxs(){

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/");
        browser.findElement(By.xpath("//*[contains(text(),'Checkboxes')]//ancestor::a")).click();
        //Тут всё ломается






    }
}
