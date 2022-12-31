package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBase;

public class O01 extends TestBase {
    @Test
    public void iframeTest01() throws InterruptedException {


        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //sayfadaki toplam iframe sayısını bulunuz.
        driver.findElement(By.xpath("//iframe"));

        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualEditor = driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        System.out.println(actualEditor);
        String expectedEditor = "Editor";
        Assert.assertTrue(actualEditor.contains(expectedEditor));

        //Paragrafdaki yaziyi silelim
        Thread.sleep(4000);
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("[id='tinymce']")).clear();

        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[id='tinymce']")).sendKeys("iframein icindeyim");

        //iframden cikalim
        driver.switchTo().defaultContent();

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        String actualElementSelenium = driver.findElement(By.xpath("(//*[@target='_blank'])[2]")).getText();
        String expectedDogrulama = "Elemental Selenium";
        Assert.assertTrue(actualElementSelenium.contains(expectedDogrulama));


    }
}