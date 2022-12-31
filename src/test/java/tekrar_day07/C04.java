package tekrar_day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBase;

public class C04 extends TestBase {

    @Test
    public void promAlert() throws InterruptedException {

        //sayfaya  git
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(5000);

        //3.butona tiklayin
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
        Thread.sleep(5000);

        //    uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("derya");
        Thread.sleep(5000);
        //    OK butonuna tıklayın
        driver.switchTo().alert().accept();

        //    ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult=driver.findElement(By.cssSelector("[style='color:green']")).getText();
        String expectedResult="You entered: derya";
        Assert.assertTrue(expectedResult.contains("derya"));

    }
}
