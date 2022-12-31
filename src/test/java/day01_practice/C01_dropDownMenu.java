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

public class C01_dropDownMenu {


    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void DropDown() {

        //1. https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        //2. dropdown'dan "Books" secenegini secin
        //a.adım locate edelim
        WebElement ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));

        //b.Adim select objesi olusturalım
        Select selectBooks = new Select(ddm);

        //c.Adim opsiyon secilir.
        selectBooks.selectByVisibleText("Books");
        //selectBooks.selectByValue("search-alias=stripbooks-intl-ship");
        //selectBooks.selectByIndex(12);

        driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();

        //4 arama cubuguna "Java" aratın
        WebElement aramaCubugu = driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));
        aramaCubugu.sendKeys("Java", Keys.ENTER);

        //5 arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramaSonucYazisi = aramaSonucu.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("Java"));


        //Kısa Yol Bunu ogrennnnn
        // String searchText = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();

        //Assert.assertTrue(searchText.contains("Java"));

    }

    @After
    public void tearDown() {
        driver.close();
    }


}
