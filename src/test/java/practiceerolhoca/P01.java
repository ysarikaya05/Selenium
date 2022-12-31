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

public class P01 {


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

        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualtitle = driver.getCurrentUrl();
        String actualUrl = driver.getTitle();
        System.out.println("Sayfa Basligi:" + actualtitle);
        System.out.println("Sayfa Url:" + actualUrl);

        //-title ve url'nin "spent" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualtitle.contains("spend") && actualUrl.contains("spend"));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com");

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains("Sitesi"));

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().refresh();


    }
    @After
    public void therDown(){
        driver.quit();
    }

}