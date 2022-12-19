import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;
    @Test
    public void fileUploadTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir") + "/src/test/java/resources/Screenshot_1.png" );
        driver.findElement(By.id("file-submit")).click();
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFiles.getText(), "Screenshot_1.png");
        driver.quit();
    }
}
