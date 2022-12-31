package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T02_Ysf {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test02() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        //Reklami kapat
        driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();

        // dropdown'dan "Baby" secenegini secin
        WebElement searchBaby=driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        Select select=new Select(searchBaby);

        select.selectByVisibleText("Baby");
        //select.selectByValue("search-alias=baby-products-intl-ship");
        //select.selectByIndex(3);

        // sectiginiz option'i yazdirin
        String sectigimOption=select.getFirstSelectedOption().getText();
        System.out.println("Sectigim Option : " + sectigimOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tumOptionlar= select.getOptions();
        int actualoptionSayisi=tumOptionlar.size();
        int expectedoptionSayisi=28;

        Assert.assertEquals(expectedoptionSayisi,actualoptionSayisi);

    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
