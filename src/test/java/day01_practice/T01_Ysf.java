package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T01_Ysf {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testDrobdown() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        //Reklami reddederek kapatalim
        driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();

        // dropdown'dan "Books" secenegini secin
        WebElement ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        Select selectDrop = new Select(ddm);
        //selectDrop.selectByVisibleText("Books");
        //selectDrop.selectByValue("search-alias=stripbooks-intl-ship");
        selectDrop.selectByIndex(5);

        // arama cubuguna "Java" aratın
        driver.findElement(By.cssSelector("[id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        String aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(aramaSonucu.contains("Java"));

    }

    @After
    public void tearDown() {
        driver.close();
    }
}