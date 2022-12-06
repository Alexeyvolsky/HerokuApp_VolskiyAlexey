import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Inputs {
    WebDriver driver;
    @Test
    public void inputsTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement number = driver.findElement(By.cssSelector("[type = number]"));
        number.sendKeys("7788");
        number.sendKeys(Keys.ARROW_UP);
        number.sendKeys(Keys.ARROW_UP);
        number.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(number.getAttribute("value"), "7789");
        number.clear();
        number.sendKeys("dfghjkl");
        Assert.assertEquals(number.getAttribute("value"), "");
    }
}
