package tekrar_day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {

    @Test
    public void handleWindowTest() throws InterruptedException {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //ILK SAYFANİN IDISINI ALALIM
        String window1Handle = driver.getWindowHandle();

        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//*[.='Opening a new window']")).getText();
        String expectedText = "Opening a new window";
        Assert.assertTrue(actualText.contains(expectedText));

        //Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertTrue(actualText.contains(expectedText));

        //Click Here butonuna basın.
        driver.findElement(By.xpath("(//*[@target='_blank'])[1]")).click();

        //        BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECIS YAPMAK ISTIYORUM
        //        BUNUN ICIN driver.getWindowHandles() ILE TUM PENCERELERIN IDLERINI ALALIM
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String handle : allWindowHandles) {
            if (!handle.equals(window1Handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        String windowTitle = driver.getTitle();
        Assert.assertEquals("New Window", windowTitle);


        //Sayfadaki textin "New Window" olduğunu doğrulayın.
        String actualWindow2Text = driver.findElement(By.xpath("(//*[.='New Window'])[2]")).getText();
        String expectedWindow2Text ="New Window";
        Assert.assertEquals(expectedWindow2Text, actualWindow2Text);
        //Assert.assertEquals("New Window",driver.findElement(By.xpath("(//*[.='New Window'])[2]")).getText());

        String window2Handle= driver.getWindowHandle();

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());


    }
}
