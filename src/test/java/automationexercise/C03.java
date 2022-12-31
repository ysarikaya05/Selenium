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

public class C03 {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test03() {


        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement logoo = driver.findElement(By.cssSelector("[src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoo.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("[class='fa fa-lock']")).click();

        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement girisLogoDgrlama = driver.findElement(By.cssSelector("[class='signup-form']"));
        Assert.assertTrue(girisLogoDgrlama.isDisplayed());

        //6. Yanlış e-posta adresi ve şifre girin
        WebElement maile = driver.findElement(By.cssSelector("[data-qa='login-email']"));
        maile.sendKeys("aaa@dd");
        WebElement pasword = driver.findElement(By.cssSelector("[data-qa='login-password']"));
        pasword.sendKeys("yus344");

        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();

        //8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        WebElement postaDogrula = driver.findElement(By.cssSelector("[style='color: red;']"));
        Assert.assertTrue(postaDogrula.isDisplayed());


    }

    @After
    public void thearDown() {
       // driver.close();
    }
}
