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

import java.time.Duration;

public class P03 {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void nameP03() {

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");


        // Click on  Calculate under Micro Apps
        driver.findElement(By.cssSelector("[id='calculatetest']")).click();

        //    Type any number in the first input
        WebElement firsNummer = driver.findElement(By.id("number1"));
        firsNummer.sendKeys("30", Keys.TAB, Keys.TAB, "30", Keys.ENTER);
        //    Type any number in the second input
        // Click on Calculate
        // Print the result
        WebElement sonuc=driver.findElement(By.cssSelector("[id='answer']"));
        System.out.println("sonuc.getText() = " + sonuc.getText());
        // close driver



    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

