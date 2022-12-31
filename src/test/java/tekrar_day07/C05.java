package tekrar_day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBase;

public class C05 extends TestBase {

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        Thread.sleep(4000);
        //Iframe nedir?
        //https://testcenter.techproeducation.com/index.php?page=iframe
        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
       // WebElement blackBorderText=driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']"));
        Thread.sleep(5000);
       // System.out.println("TEXT:"+ blackBorderText.getText());//(An iframe with a thin black border)yaziyi yazdirdik
        //Assert.assertTrue(blackBorderText.isDisplayed());

        String actualMetin=driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();
        String expectedMetin="An iframe with a thin black border";
        Assert.assertTrue(actualMetin.contains(expectedMetin));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        WebElement iframe=driver.findElement(By.xpath("//*/iframe"));
        driver.switchTo().frame(iframe);//İframe giris yaptik

        WebElement applicationsListsText=driver.findElement(By.cssSelector("[class='display-5 fw-bold']"));
        System.out.println(applicationsListsText.getText());
        Assert.assertTrue(applicationsListsText.isDisplayed());

        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilim
        driver.switchTo().defaultContent();//iframe den cikis yaptik
        //driver.switchTo().parentFrame();

        WebElement dogrulamaPoweredBy=driver.findElement(By.cssSelector("[class='blog-footer']"));//   //footer[@class='blog-footer']//p[1]
                                                                                                  //   (//footer[@class='blog-footer'][1])//p
        Assert.assertTrue(dogrulamaPoweredBy.isDisplayed());

        /*
        How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
***driver.findElements(By.tagName(“iframe”));
***driver.findElements(By.xpath(“//iframe”));
————————————
Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
***2 farkli yol vardır.
***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
———————————-
What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
*** Oncelikle her ikiside framein misina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
—————————————
What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
Iframe. Cozum : switch to iframe
Alert. Cozum : switch to alert
New window(Yeni pencere) : switch to window
         */




    }
}
