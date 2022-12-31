package day02_practtic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void checkbox() {

        // "https://demo.guru99.com/test/radio.html" adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        //Reklami kapat
        //driver.findElement(By.xpath("(//*[@class='action-wrapper'])[3]")).click();
        //driver.findElement(By.xpath("(//*[@class='mat-button-wrapper'])[6]")).click();

        // checkbox elementlerini locate edin
        WebElement checkbox1= driver.findElement(By.id("vfb-6-0"));
        WebElement checkbox2= driver.findElement(By.id("vfb-6-1"));
        WebElement checkbox3= driver.findElement(By.id("vfb-6-2"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox3.isSelected()) {
            checkbox3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkbox2.isSelected());

    }
}
