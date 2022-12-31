package automationexercise;

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

public class C04 {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void soru04() {


        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Signup / Login' button
        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Logout' button
        //10. Verify that user is navigated to login page

        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement gorunurLogo=driver.findElement(By.cssSelector("[src='/static/images/home/logo.png']"));
        Assert.assertTrue(gorunurLogo.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. "Hesabınıza giriş yapın"ın görünür olduğunu doğrulayın
        WebElement girisLogoGrnr=driver.findElement(By.cssSelector("[class='signup-form']"));
        Assert.assertTrue(girisLogoGrnr.isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        WebElement name = driver.findElement(By.cssSelector("[type='text']"));
        name.sendKeys("yusuf");
        WebElement mail = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        mail.sendKeys("alc6i@gmail.com");

        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        //9. 'Çıkış' düğmesine tıklayın
        //10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
    }

    @After
    public void tearDown() {
        //driver.close();
    }
}
