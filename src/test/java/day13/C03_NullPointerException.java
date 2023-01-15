package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilites.TestBase;

public class C03_NullPointerException{

    WebDriver driver;
    Faker faker;

    @Test
    public void nullPointerException() {

        driver.get("https://www.techproeducation.com");//java.lang.NullPointerException

    }

    @Test
    public void nullPointerException2() {

      //  faker=new Faker();
        System.out.println(faker.name().fullName());  //java.lang.NullPointerException


    }
}
