package practiceerolhoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void name() {
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement addButon= driver.findElement(By.cssSelector("[onclick='addElement()']"));
        for (int i = 0; i < 100 ; i++) {
            addButon.click();
        }
        // 100 defa basıldığını test ediniz
        List<WebElement>deleteButon=driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(deleteButon.size(),100);

        // 90 defa delete butonuna basınız

        for (int i = 0; i < 90 ; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement>deleteButonList=driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(deleteButonList.size(),10);

        // Sayfayı kapatınız
    }
    @After
    public void theroDown(){
        driver.quit();
    }
}
