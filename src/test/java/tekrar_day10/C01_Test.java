package tekrar_day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBase;

public class C01_Test extends TestBase {

    @Test
    public void rightClickTest() {

        //    https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu ");
        Actions actions=new Actions(driver);
        WebElement kutu=driver.findElement(By.cssSelector("[id='hot-spot']"));
        actions.contextClick(kutu).perform();  //contextClick(sag tiklama)

        //    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //    Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }

    @Test
    public void rightClickTest1() {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);
        WebElement kutuu=driver.findElement(By.id("hot-spot"));
        actions.contextClick(kutuu).perform();
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();



    }
}
