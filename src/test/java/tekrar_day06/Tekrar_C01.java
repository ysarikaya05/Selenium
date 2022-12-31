package tekrar_day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Tekrar_C01 {


    WebDriver driver;

    //    Eger test sinifinda birden fazla method olusturulmussa, @Before kullanir
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() {

        //1.Locate dropdown
        WebElement year = driver.findElement(By.cssSelector("[id='year']"));
        //2.select objesi olusturalim
        Select select = new Select(year);
        // 3. Select object i kullaarak 3 farkli sekilde secim yapabilirim
        select.selectByIndex(22);


    }
}
