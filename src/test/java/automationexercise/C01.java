package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.buffer.ByteBufAllocatorMetric;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;

public class C01 {
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
        //1.yol
        WebElement dogrulamaLogo = driver.findElement(By.cssSelector("[class='logo pull-left']"));
        Assert.assertTrue(dogrulamaLogo.isDisplayed());
        // 2.Yol
        // Assert.assertTrue(driver.findElement(By.cssSelector("[class='logo pull-left']")).isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("[href='/login']")).click();

        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement signup = driver.findElement(By.className("signup-form"));
        Assert.assertTrue(signup.isDisplayed());

        //6. Adı ve e-posta adresini girin
        WebElement name = driver.findElement(By.cssSelector("[type='text']"));
        name.sendKeys("yusuf");
        WebElement mail = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        mail.sendKeys("yusufsssaarrriaiiai@gmail.com");

        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        WebElement hesapBilgileri = driver.findElement(By.xpath("(//*[@class='title text-center'])[1]"));
        Assert.assertTrue(hesapBilgileri.isDisplayed());

        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        driver.findElement(By.cssSelector("[id='id_gender1']")).click();

        WebElement passworde = driver.findElement(By.xpath("(//*[@class='form-control'])[3]"));
        passworde.sendKeys("1234");

        WebElement day = driver.findElement(By.xpath("(//*[@class='form-control'])[4]"));
        Select dayDDM = new Select(day);
        dayDDM.selectByValue("1");

        WebElement mount = driver.findElement(By.xpath("(//*[@class='form-control'])[5]"));
        Select mountDDM = new Select(mount);
        mountDDM.selectByValue("5");

        WebElement year = driver.findElement(By.xpath("(//*[@class='form-control'])[6]"));
        Select yearDDM = new Select(year);
        yearDDM.selectByValue("2013");

        Actions action=new Actions(driver);

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        action.sendKeys(Keys.TAB,Keys.SPACE).sendKeys(Keys.TAB,Keys.SPACE).sendKeys(Keys.TAB).perform();

        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        action.sendKeys("yusuf",Keys.TAB).sendKeys("sari",Keys.TAB).sendKeys(Keys.TAB).sendKeys("Ried",Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("Canada",Keys.TAB).sendKeys("Gros",Keys.TAB).sendKeys("Stock",Keys.TAB).sendKeys("65555",Keys.TAB)
                .perform();

        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür
        WebElement hesapOlusturuldu=driver.findElement(By.cssSelector("[class='title text-center']"));
        Assert.assertTrue(hesapOlusturuldu.isDisplayed());


        //15. 'Devam Et' düğmesini tıklayın
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();

        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement hesapAcmaGrldu= driver.findElement(By.cssSelector("[class='fa fa-user']"));
        Assert.assertTrue(hesapAcmaGrldu.isDisplayed());

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.cssSelector("[href='/delete_account']")).click();

        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
        WebElement hesapSilindiGrnr=driver.findElement(By.cssSelector("[class='title text-center']"));
        Assert.assertTrue(hesapSilindiGrnr.isDisplayed());

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
    }

    @After
    public void therDown() {
         driver.close();
    }


}
