package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBase;

public class SR04 extends TestBase {
    @Test
    public void name() {

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.cssSelector("[style='color: orange;']")).click();

        //4. Sol taraftaki çubukta Markaların göründüğünü doğrulayın
        WebElement markalar=driver.findElement(By.cssSelector("[class='nav nav-pills nav-stacked']"));
        Assert.assertTrue(markalar.isDisplayed());

        //5. Herhangi bir marka adına tıklayın

        driver.findElement(By.cssSelector("[href='/brand_products/Polo']"));


        //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın.
        //7. Sol taraftaki çubukta herhangi bir başka marka bağlantısına tıklayın
        //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın

    }

}
