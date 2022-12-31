package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforClassAfterClass {

    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
@BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
 */

     @BeforeClass
    public static void SetUp(){
         System.out.println("Butun testlerden once calisti");
         System.out.println("--------------------------------");

     }
     @AfterClass
    public static void tearDown(){
         System.out.println("Butun testlerden sonra calisti");
         System.out.println("--------------------------------");
     }
     @Before
     public void setUp1(){
         System.out.println("Her testen once calistir");
         System.out.println("--------------------------------");
     }
     @After
     public void tearDown1(){
         System.out.println("Her testen sonra calisir");
         System.out.println("--------------------------------");
     }
     @Test
    public void test01(){
         System.out.println("ilk test");
         System.out.println("--------------------------------");
     }
     @Test
    public void test02(){
         System.out.println("ikinci test");
     }
     @Ignore  //Eger bir testi calistirmak istemezsek bu sekilde kullanabiliriz.
     @Test
    public void test03(){
         System.out.println("Ucuncu test");
     }
}
