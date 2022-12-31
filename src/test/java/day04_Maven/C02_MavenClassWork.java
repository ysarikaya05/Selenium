package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("i[class='icon-signin']")).click();

        //3.Login alanine “username” yazdirin
        WebElement login=driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

        //4.Password alanine “password” yazdirin
        WebElement password=driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //6.Pay Bills sayfasina gidin
        driver.navigate().back();

        //Online Banking butonuna basınız sonra Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount=driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("500");

        //8.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("21.12.2022");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj= driver.findElement(By.xpath("//*[@id='alert_content']"));
        if (mesaj.isDisplayed()){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAILED");
    }
}
