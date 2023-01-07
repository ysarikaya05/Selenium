package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilites.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandle2 extends TestBase {

    @Test
    public void name() {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        String window1Handle = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        String expectedText = "Opening a new window";
        Assert.assertTrue(text.isDisplayed());

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitleThe = driver.getTitle();
        String expectedTextThe = "The Internet";
        Assert.assertTrue(actualTitleThe.contains(expectedTextThe));

        ;

        //Click Here butonuna basın.
        driver.findElement(By.xpath("(//*[@target='_blank'])[1]")).click();

        waitFor(3);

        switchToWindow(1);
        // switchToWindow("New Window");

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitleNew2 = driver.getTitle();
        String expectedTitleNew2 = "New Window";
       Assert.assertEquals(expectedTitleNew2, actualTitleNew2);

    }
}
