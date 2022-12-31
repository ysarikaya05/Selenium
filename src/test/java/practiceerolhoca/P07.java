package practiceerolhoca;

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

import java.time.Duration;

public class P07 {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testNutella() {

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

//       cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

//       Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String titleBaslik = "Google";
        Assert.assertTrue(actualTitle.contains(titleBaslik));


//       Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.cssSelector("[class='gLFyf']"));
        aramaCubugu.sendKeys("Nutella", Keys.ENTER);

//       Bulunan sonuc sayisini yazdirin
        String[] sonucSayisi = driver.findElement(By.cssSelector("[id='result-stats']")).getText().split(" ");
        String sonuc = sonucSayisi[1];
        System.out.println("Sonuc sayisi :" + sonuc);

//       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        sonuc=sonuc.replaceAll("\\D", ""); // ReplaceAll() ile \\D'i kullanarak bütün noktalama işaretlerini hiçlikle değiştirdik.
        int istenenSayi=10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);

//


    }
    @After
    public void tearDown(){
        //Sayfayi kapatin
        driver.close();

    }
}
