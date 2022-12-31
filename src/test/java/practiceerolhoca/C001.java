package practiceerolhoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C001 {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {


        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement logo=driver.findElement(By.cssSelector("[src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("[href='/login']")).click();

        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement girisLogo=driver.findElement(By.cssSelector("[class='signup-form']"));
        Assert.assertTrue(girisLogo.isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        WebElement name = driver.findElement(By.xpath("(//*[@type='email'])[1]"));
        name.sendKeys("ahmet@nehaber.com", Keys.TAB,"12345",Keys.TAB,Keys.ENTER);


        //7. 'Giriş' düğmesine tıklayın


        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        //9. 'Hesabı Sil' düğmesini tıklayın
        //10. 'HESAP SİLİNDİ!' görünür

    }
}
