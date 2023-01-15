package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    @Test
    public void timeOutException() {

        /*
TimeOutException explicit wait kullandigimda ve locator bulunamadiginda alirim
 */

        /*
        Explicit wait kullanildiginda, ve element bulunamadiginda alinir.
        Explicit wait & yanlis locator-> timeout
        Explicit wait & doğru locator & sure yeterli degil -> timeout
        Explicit wait & dogru locator & sure yeterli & iframe var ->  time out
         */

        driver.get("https://www.techproeducation.com");
        //        Explit wait icin olusturdugumuz methodlardan birini kullanalim
        //        Parametre 1: beklemek istedigim element, Parametre 2: Max sure

               // waitForVisibility(By.xpath("//input[@type='searchh']"),15)//org.openqa.selenium.TimeoutException:
                //       .sendKeys("QA"+ Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:

    }
}
