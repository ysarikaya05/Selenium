package tekrar_day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBase;

public class C03_ extends TestBase {

    @Test
    public void dismissAlert() throws InterruptedException {

        //siteye git
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //cancel e tıkla
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
        Thread.sleep(4000);

        //uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        Thread.sleep(4000);

        //        ve result mesajının “You clicked: Cancel” oldugunu test edin.
        String actualResult=driver.findElement(By.cssSelector("[id='result']")).getText();
        String expectedResult="You clicked: Cancel";
        Assert.assertEquals(expectedResult, actualResult);
        Thread.sleep(4000);

    }
}
