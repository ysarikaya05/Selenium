package practiceerolhoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class P02 {
    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void p02() {
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("(//*[@class='ez-switch-view-btn '])[2]")).click();

        //fill the firstname
        WebElement firstname= driver.findElement(By.cssSelector("[name='firstname']"));
        firstname.sendKeys("yusu", Keys.TAB);
        Actions actions=new Actions(driver);
        actions.sendKeys("Sari", Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB,Keys.SPACE).sendKeys(Keys.TAB).sendKeys("11.01.1990",Keys.TAB).
              sendKeys(Keys.TAB,Keys.ARROW_RIGHT,Keys.SPACE).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE).
                sendKeys(Keys.TAB,"Europe",Keys.TAB).sendKeys(Keys.TAB,Keys.LEFT_SHIFT).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();

        //fill the lastname
        //check the gender
        //check the experience
        //fill the date
        //choose your profession -> Automation Tester
        //choose your tool -> Selenium Webdriver
        //choose your continent -> Antartica
       //choose your command  -> Browser Commands
       //click submit button
        /*
             WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        //fill the firstname
        WebElement firstname = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstname.sendKeys("Erol",Keys.TAB,"Evren",Keys.TAB,Keys.ARROW_RIGHT,Keys.TAB,
                Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.TAB,"12/12/2022",Keys.TAB,Keys.TAB
        ,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,"Africa",Keys.TAB,Keys.LEFT_CONTROL,
                Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);

        //fill the lastname
        //check the gender
        //check the experience
        //fill the date
        //choose your profession -> Automation Tester
        //choose your tool -> Selenium Webdriver
        //choose your continent -> Antartica
        //choose your command  -> Browser Commands
        //click submit button


    }
}
         */


    }
    @After
    public void therDown(){
        driver.close();
    }
}
