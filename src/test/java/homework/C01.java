package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBase;

public class C01 extends TestBase {

    @Test
    public void actionsClassHomeWorkTest() {

        //Keyboard Base Actions
        //Homework
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirstKutu=driver.findElement(By.cssSelector("[class='dropdown hover']"));
        actions.moveToElement(hoverOverMeFirstKutu).perform();

        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        //Popup mesajini yazdirin
        String result="Well done you clicked on the link!";
        System.out.println("Popup mesaji: " + result);

        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //“Click and hold" kutusuna basili tutun
       WebElement clickAndHoldKutusu= driver.findElement(By.cssSelector("[id='click-box']"));
       actions.clickAndHold(clickAndHoldKutusu).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldKutusu.getText());


        //8- “Double click me" butonunu cift tiklayin
        WebElement doobleClickMeButonu =driver.findElement(By.cssSelector("[id='double-click']"));
        actions.doubleClick(doobleClickMeButonu).perform();
    }
}
