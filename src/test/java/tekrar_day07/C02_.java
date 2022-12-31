package tekrar_day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBase;

public class C02_ extends TestBase {

    @Test
    public void alert01() throws InterruptedException {

        //1. butona tıklayın,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. yuyarıdaki OK butonuna tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        Thread.sleep(5000);
        //3. ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        String actualResult=driver.findElement(By.cssSelector("[id='result']")).getText();
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult);

    }
}
