package day05_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Work {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }




        //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
        //○ title Test  => Sayfa başlığının “Amazon” oldugunu testedin
        //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) testedin
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        //○ wrongTitleTest => Sayfa basliginin “amazon” olmadiginidogrulayin



    @Test
    public void title() {
        String actualTitle =driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle ="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void image() {
        WebElement amazonLogo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogo.isDisplayed());

    }

    @Test
    public void SearchBox () {
        WebElement searchBox=driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());

    }

    @Test
    public void wrongTitleTest() {
        String actualTitle =driver.getTitle();
        String expectedTitle ="amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));



    }

    @After
    public void tearDown(){
        driver.close();

    }


}
