package automationexercise;

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
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C02_Aktions {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void nameAktions() throws InterruptedException {


        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement logo = driver.findElement(By.cssSelector("[src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("[href='/login']")).click();

        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement girisYapinDgrlma = driver.findElement(By.xpath("(//*[@class='col-sm-4'])[2]"));
        Assert.assertTrue(girisYapinDgrlma.isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        WebElement name = driver.findElement(By.cssSelector("[type='text']"));
        name.sendKeys("yusuf");
        WebElement mail = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        mail.sendKeys("alc6i@gmail.com");

        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //mr tıkla
        driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();
        //Sırayla butun bilgileri giriniz?
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("deryaa", Keys.TAB).sendKeys("1233", Keys.TAB).sendKeys("June", Keys.TAB).
                sendKeys("2003", Keys.TAB).sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB).
                sendKeys("ali", Keys.TAB). sendKeys("sari", Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Gross", Keys.TAB).sendKeys(Keys.TAB).sendKeys("Israel", Keys.TAB).sendKeys("Bahnhof", Keys.TAB).
                sendKeys("Almn", Keys.TAB).sendKeys("123445", Keys.TAB).sendKeys("8654332", Keys.TAB).perform();

        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();
        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement hesapOlusturuldu = driver.findElement(By.cssSelector("[class='title text-center']"));
        Assert.assertTrue(hesapOlusturuldu.isDisplayed());

        // 'Devam Et' düğmesini tıklayın

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();

        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.cssSelector("[href='/delete_account']")).click();

        //10. 'HESAP SİLİNDİ!' görünür
        WebElement hesapSilindiGrnr = driver.findElement(By.cssSelector("[class='title text-center']"));
        Assert.assertTrue(hesapSilindiGrnr.isDisplayed());
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();


    }

    @After
    public void tearDown() {
         driver.close();
    }
}
