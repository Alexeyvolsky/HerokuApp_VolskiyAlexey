import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.util.converter.ByteStringConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hovers {
    WebDriver driver;
    @Test
    public void hoversTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement we1 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/img"  ));
        action.moveToElement(we1).build().perform();
        WebElement user1 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/div/h5"));
        Assert.assertEquals(user1.getText(), "name: user1");
        WebElement link1 =driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/div/a"));
        link1.click();
        WebElement newpage1 =driver.findElement(By.xpath("//html/body/h1"));
        Assert.assertTrue(newpage1.isDisplayed());
        driver.navigate().back();
        WebElement we2 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/img"));
        action.moveToElement(we2).build().perform();
        WebElement user2 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/div/h5"));
        Assert.assertEquals(user2.getText(), "name: user2");
        WebElement link2 =driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/div/a"));
        link2.click();
        WebElement newpage2 =driver.findElement(By.xpath("//html/body/h1"));
        Assert.assertTrue(newpage2.isDisplayed());
        driver.navigate().back();
        WebElement we3 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[3]/img"));
        action.moveToElement(we3).build().perform();
        WebElement user3 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[3]/div/h5"));
        Assert.assertEquals(user3.getText(), "name: user3");
        WebElement link3 =driver.findElement(By.xpath("//html/body/div[2]/div/div/div[3]/div/a"));
        link3.click();
        WebElement newpage3 =driver.findElement(By.xpath("//html/body/h1"));
        Assert.assertTrue(newpage3.isDisplayed());
        driver.navigate().back();


















    }
}
