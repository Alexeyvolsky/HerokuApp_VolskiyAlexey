import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Checkboxes {
    WebDriver driver;
    @Test
    public void checkboxesTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBox = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(checkBox.get(0).isSelected());
        checkBox.get(0).click();
        Assert.assertTrue(checkBox.get(0).isSelected());
        Assert.assertTrue(checkBox.get(1).isSelected());
        checkBox.get(1).click();
        Assert.assertFalse(checkBox.get(1).isSelected());
    }
}
