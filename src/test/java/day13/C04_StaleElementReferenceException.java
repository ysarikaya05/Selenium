package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    @Test
    public void staleElementReferenceException1() {

        /*
        Stale Element means the element is no longer fresh. It is old and no longer available
When the element is no longer fresh on the page and you try to use it
When the element is detached from the DOM
When the element is removed after session started
Solution:
Relocate the same element again. You can use a new variable name as well.
Example:
Stale Element = eski, kullanılamaz durumda, kullanım artık elverişli degil
-Sayfayi yenilediğinizde (refresh())
-Sayfada ileri geri gittimizde
COZUM:
Elementi tekrar bulmak
  /*
        StateElementReferenceException
StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
Sayfayı yenilediğimizde,
sayfada ileri geri gittiğimizde meydana gelen exception'dır.

    Çözüm
Elemanı tekrar bulmak.
         */

        driver.get("https://www.techproeducation.com");
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink=driver.findElement(By.linkText("LMS LOGIn"));
        waitFor(3);
        lmsLoginLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));
        waitFor(3);

//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar

        driver.navigate().back();
        waitFor(3);
        lmsLoginLink.click();
        waitFor(3);
    }

    @Test
    public void staleElementReferenceException2() {

        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
//        SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKDEN SONRA KULLANMAK ISTEDIM

        lmsLoginLink.click();// org.openqa.selenium.StaleElementReferenceException

//        COZUM ESKI(SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
//        driver.findElement(By.linkText("LMS LOGIN")).click();

    }
}
