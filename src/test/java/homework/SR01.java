package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBase;

import java.util.List;

public class SR01 extends TestBase {

    @Test
    public void Text01() throws InterruptedException {

        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //maximize the web site
        // ikinci emojiye tıklayın
        driver.switchTo().frame(1);//İframenin icerisine girdim
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        Thread.sleep(5000);

       // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement>tumEmojiler=driver.findElements(By.xpath("//div[@id='nature']//div//img"));
        for (WebElement each : tumEmojiler) {
            each.click();

        }
        // ana iframe'e geri dön
        driver.switchTo().defaultContent();

       //formu doldurun,(Formu istediğiniz metinlerle doldurun)
       // uygula butonuna tıklayın
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("Emoji",Keys.TAB).sendKeys("Name1",Keys.TAB).sendKeys("Name2",Keys.TAB).sendKeys("Name3",Keys.TAB).
                sendKeys("Name4",Keys.TAB).sendKeys("Name5",Keys.TAB).sendKeys("Name6",Keys.TAB).sendKeys("Name7",Keys.TAB).sendKeys("Name8",Keys.TAB).
                sendKeys("Name9",Keys.TAB).sendKeys("Name10",Keys.TAB).sendKeys(Keys.ENTER).perform();




    }
}
