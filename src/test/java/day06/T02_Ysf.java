package day06;

import com.github.dockerjava.api.command.CopyArchiveToContainerCmd;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T02_Ysf {

    WebDriver driver;


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    //    REUSABLE METHOD: Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim.

    public  void selectFromDrobDown01(WebElement drobdown ,String secenek){

        List<WebElement>options=drobdown.findElements(By.tagName("option"));
        for (WebElement eachOption : options){
            if (eachOption.getText().contains(secenek)){
                eachOption.click();
                break;
            }
        }


    }

    @Test
    public void selectDrobdown() {
        selectFromDrobDown01(driver.findElement(By.cssSelector("[id='year']")),"2007");
        selectFromDrobDown01(driver.findElement(By.cssSelector("[id='month']")),"April");
        selectFromDrobDown01(driver.findElement(By.cssSelector("[id='day']")),"21");
        selectFromDrobDown01(driver.findElement(By.cssSelector("[id='state']")),"Florida");


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
