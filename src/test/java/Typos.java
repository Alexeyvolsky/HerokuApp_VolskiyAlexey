import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Typos {
    WebDriver driver;
    @Test
    public void typosTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> checkText = driver.findElements(By.tagName("p"));
        Assert.assertEquals(checkText.size(),2);
        Assert.assertEquals(checkText.get(0).getText(),"This example demonstrates a typo being introduced. It does it randomly on each page load.");
        Assert.assertEquals(checkText.get(1).getText(),"Sometimes you'll see a typo, other times you won't.");

    }
}
