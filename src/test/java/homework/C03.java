package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilites.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03 extends TestBase {

    @Test
    public void actionTest() {

        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement aramaKutusu = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        System.out.println("aramaKutusu.getText() = " + aramaKutusu.getText());

        //dropdown menude 40 eleman olduğunu doğrulayın
        WebElement dropdownAramaKutusu = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        Select select = new Select(dropdownAramaKutusu);
        List<WebElement> options = select.getOptions();
        options.stream().forEach(t -> System.out.println(t.getText()));
        System.out.println(options.size());

    }

    @Test
    public void Test2() {
        driver.get("https://www.amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement dropdownMenu = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        Select select = new Select(dropdownMenu);
        select.selectByIndex(10);
        waitFor(3);

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String actualAramaSonucu = driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedSonuc = "iphone";
        Assert.assertTrue(actualAramaSonucu.contains(expectedSonuc));

        //ikinci ürüne relative locater kullanarak tıklayin
        List<WebElement> urunler = driver.findElements(By.xpath("//img[@class='s-image']"));
        urunler.get(2).click();


        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String productTitle = driver.getTitle();
        String price = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        System.out.println(productTitle + "  " + price);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        //driver.findElement(By.xpath("//*[@id='attach-close_sideSheet-link']")).click();
        String navCardCount = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
        int navCardCountint = Integer.parseInt(navCardCount);
        Assert.assertTrue(navCardCountint == 1);
    }

}


//Test03
//yeni bir sekme açarak amazon anasayfaya gidin
//dropdown’dan bebek bölümüne secin
//bebek puset aratıp bulundan sonuç sayısını yazdırın
//sonuç yazsının puset içerdiğini test edin
//5-üçüncü ürüne relative locater kullanarak tıklayin
//6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
//1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın



