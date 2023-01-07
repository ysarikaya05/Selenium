package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBase;

public class C04_Soru12 extends TestBase {

    @Test
    public void exercise12Test() {


//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully  //Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt='Website for automation practice']")).isDisplayed());

//4. Click 'Products' button
        driver.findElement(By.cssSelector("[href='/products']")).click();

        //Reklami kapatiyorum
        driver.navigate().refresh();
        // driver.findElement(By.cssSelector("[id='dismiss-button']")).click();

//5. Hover over first product and click 'Add to cart'  //İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='grippy-host']"))).click().perform();
        waitFor(2);
        WebElement urun1 = driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]"));
        String urun1Name = "Blue Top";
        waitFor(2);
        actions.moveToElement(urun1).click().perform();
        //36 ve 38 ayni islemi yapiyor.
        // actions.moveToElement(driver.findElement(By.cssSelector("(//*[@class='btn btn-default add-to-cart'])[1]"))).click();

//6. Click 'Continue Shopping' button
        waitFor(2);
        driver.findElement(By.cssSelector("[class='btn btn-success close-modal btn-block']")).click();

//7. Hover over second product and click 'Add to cart' //Fareyle ikinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        WebElement urun2 = driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]"));
        String urun2Name = "Men Tshirt";
        waitFor(2);
        actions.moveToElement(urun2).click().perform();
        waitFor(4);


//8. Click 'View Cart' button //Sepeti Görüntüle' düğmesini tıklayın
        actions.moveToElement(driver.findElement(By.xpath("//u"))).click().perform();


        //9. Verify both products are added to Cart //Her iki ürünün de Sepete eklendiğini doğrulayın
        String sepet1 = driver.findElement(By.xpath("(//h4)[2]")).getText();
        String sepet2 = driver.findElement(By.xpath("(//h4)[3]")).getText();
        Assert.assertEquals(urun1Name, sepet1);
        Assert.assertEquals(urun2Name, sepet2);

//10. Verify their prices, quantity and total price //Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın
        String price1Urun = driver.findElement(By.xpath("(//tbody//tr//td[3]//p)[1]")).getText();
        String price2Urun = driver.findElement(By.xpath("(//tbody//tr//td[3]//p)[2]")).getText();
        String total1Urun = driver.findElement(By.xpath("(//tbody//tr//td[5]//p)[1]")).getText();
        String total2Urun = driver.findElement(By.xpath("(//tbody//tr//td[5]//p)[2]")).getText();
        int urunAdet = 2;
        int urun1SepetAdet = Integer.parseInt(driver.findElement(By.xpath("(//tbody//tr//td[4]//button[@class='disabled'])[1]")).getText());
        int urun2SepetAdet = Integer.parseInt(driver.findElement(By.xpath("(//tbody//tr//td[4]//button[@class='disabled'])[2]")).getText());

        Assert.assertEquals(price1Urun, total1Urun);
        Assert.assertEquals(price2Urun, total2Urun);
        Assert.assertEquals(urunAdet, (urun1SepetAdet + urun2SepetAdet));


    }
}
