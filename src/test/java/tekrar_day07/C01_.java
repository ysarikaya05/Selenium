package tekrar_day07;

import org.junit.Assert;
import org.junit.Test;
import utilites.TestBase;

public class C01_ extends TestBase {

    /*
   UTILITIES:
   - Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase -> Bugun
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra
   - Utilities paketinde Test case'ler yazilmaz.
   - Sadece tekrar kullanilabilecek destek siniflari(Support Class) olusturulur.
   - Bu support class'lar test case'lerin yazilmasini hizlandirir.
 */

    @Test
    public void name() {
        //        techproeducation ana sayfasina git
        driver.get("https://www.techproeducation.com");

        //        ve titlein 'Bootcamps' kelimesini icerdigini test edelim
        String titleBootcamps= driver.getTitle();
        Assert.assertTrue(titleBootcamps.contains("Bootcamps"));
    }
}
