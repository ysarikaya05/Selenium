package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.TestBase;

public class C02_KeyboardAction extends TestBase {

    @Test
    public void keyboardActionTest() {

        //Bir Class olusturalim KeyboardActions2
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
       waitFor(2);
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       actions.sendKeys(Keys.PAGE_DOWN).perform();


       //videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();
        waitFor(3);




    }
}
