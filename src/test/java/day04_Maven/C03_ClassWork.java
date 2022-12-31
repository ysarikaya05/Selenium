package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2 https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3 cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();

        //4 Sayfa basliginin "Google" ifadesi icerdigini test edin
        WebElement sayfaBasligi = driver.findElement(By.xpath("//*[@id='hplogo']"));
        if (sayfaBasligi.equals("Google")) {
            System.out.println("Google basligi testi PASSED");
        } else System.out.println("Google basligi testi FAILED");

        //5 Arama cubuguna "Nutella" yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaCubugu.sendKeys("Nutella", Keys.ENTER);

        //6 Bulunan sonuc sayisini yazdirin
        WebElement aramaBulunan = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("aramaBulunan" + aramaBulunan.getText());

        //7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin

/*

        String[] sonuc = sonucSayisi.get(0).getText().split(" ");
        System.out.println(sonuc[1]);
        String sonucReal = sonuc[1].toString();
        String sayi = sonucReal.replaceAll("\\p{Punct}", "");
        System.out.println("sayi =" + sayi);
        int num = Integer.valueOf(sayi);
        if (num > 10000000) {
            System.out.println("Passed");
        } else System.out.println("Failed");

 */
        //8 Sayfayi kapatin
    }
}