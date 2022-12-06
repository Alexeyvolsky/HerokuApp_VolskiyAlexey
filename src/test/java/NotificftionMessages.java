import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class NotificftionMessages {
    WebDriver driver;
    @Test
    public void messagesTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement test = driver.findElement(By.xpath("//html/body/div[2]/div/div/p/a"));
        test.click();
        WebElement flash = driver.findElement(By.id("flash"));
        flash.getText();
        Assert.assertEquals(flash.getText(), "Action unsuccesful, please try again\n" + "×");
    }
}
