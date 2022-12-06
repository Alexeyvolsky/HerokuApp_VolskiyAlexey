import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SortableDataTables {
    WebDriver driver;
    @Test
    public void tableTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement exampleTest1 = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        Assert.assertEquals(exampleTest1.getText(),"Smith");
        WebElement exampleTest2 = driver.findElement(By.xpath("//table//tr[4]//td[3]"));
        Assert.assertEquals(exampleTest2.getText(),"tconway@earthlink.net");
        WebElement exampleTest3 = driver.findElement(By.xpath("//table//tr[4]//td[5]"));
        Assert.assertEquals(exampleTest3.getText(),"http://www.timconway.com");
        WebElement exampleTest4 = driver.findElement(By.xpath("//table//tr[3]//td[2]"));
        Assert.assertEquals(exampleTest4.getText(),"Jason");
        WebElement exampleTest5 = driver.findElement(By.xpath("//table//tr[1]//td[5]"));
        Assert.assertEquals(exampleTest5.getText(),"http://www.jsmith.com");







    }
}
