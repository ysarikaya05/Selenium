package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilites.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementException() {

        driver.get("https://www.techproeducation.com/");

        driver.findElement(By.cssSelector("elementor-search-form__input"))// org.openqa.selenium.NoSuchElementException:
                .sendKeys("QA"+ Keys.ENTER);



    }
}
