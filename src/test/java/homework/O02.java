package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBase;

import java.util.Set;

public class O02 extends TestBase {

    @Test
    public void name() throws InterruptedException {

        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //ILK SAYFANİN HANDELİNİ(IDISINI) ALALIM
        String windowHandle1=driver.getWindowHandle();
        System.out.println(windowHandle1);

        //Title in ‘Windows’ oldugunu test edin
        String actualTitleWindows=driver.getTitle();
        String expectedTitleWindows="Windows";
        Assert.assertTrue(actualTitleWindows.contains(expectedTitleWindows));

        //Click here a tiklayin
        driver.findElement(By.cssSelector("[href='index.php?page=new-windows']")).click();
        Thread.sleep(4000);

        //        BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECIS YAPMAK ISTIYORUM
        Set<String>allWindowsHandles=driver.getWindowHandles();
        System.out.println(allWindowsHandles);
        for (String w : allWindowsHandles){
            if (!w.equals(windowHandle1)){
                driver.switchTo().window(w);
                break;
            }

        }

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        String windowTitle2=driver.getTitle();
        String expectedTitle2="New Window";
        Assert.assertTrue(windowTitle2.contains(expectedTitle2));

        // //Sayfadaki textin "New Window" olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.findElement(By.xpath("(//*[.='New Window'])[2]")).getText());




    }
}
