package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilites.TestBase;

public class C03_CanHoca1 extends TestBase {
    @Test
    public void Test01() {


        //1. 'https://www.amazon.com.tr/' adresine gidin"
        driver.get("https://www.amazon.com.tr/");
        WebElement iframe=driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);



        //  2. iPhone13 512'yi arayın
        WebElement aramaCubugu= driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));
        aramaCubugu.sendKeys("iPhone13 512", Keys.ENTER);




        //  3. Sonuçların listelenip listelenmediğini kontrol edin
        //  4. Listenin en üstündeki iPhone13'e tıklayın
        //  5. Her boyut için aşağıdaki değerleri günlüğe kaydedin Boyut bilgisi Fiyat Renk Stok durumu
        //  Bu ekran görüntüsüne benzer bir çıktı bekliyoruz.
        //  iPhone 13
        //  Boyut:512 GB
        //  Renk: Yıldız Işığı Fiyat: 18.384, 01TL
        //  Stok:Stokta sadece 1 adet kaldı.
    }

}