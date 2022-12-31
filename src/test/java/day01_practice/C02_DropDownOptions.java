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

public class C02_DropDownOptions {

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

        // dropdown'dan "Baby" secenegini secin
        //a.adım locate edelim
        WebElement ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));

        //b.Adim select objesi olusturalım
        Select selectBooks = new Select(ddm);

        //c.Adim opsiyon secilir.
        selectBooks.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        String sectigimOption = selectBooks.getFirstSelectedOption().getText();
        System.out.println("sectigimOptin = " + sectigimOption);

        //Reklami kapat
        driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tumoptionlar = selectBooks.getOptions();
        int actionsOptionSayisi = tumoptionlar.size();
        int expectedOptionSayisi = 28;

        Assert.assertEquals(expectedOptionSayisi, actionsOptionSayisi);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
