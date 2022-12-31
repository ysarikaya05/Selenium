package tekrar_day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBase;

public class C06 extends TestBase {

    @Test
    public void name() {

        //Siteye gidelim
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //        Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String blackBorder =driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        String expectedBorder="black border";
        Assert.assertTrue(blackBorder.contains(expectedBorder));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Applications lists elementi iframe in icinde. Iframe switch yapmam sart
        driver.switchTo().frame(0);

        String actualIcMetin=driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedMetin="Applications lists";
        Assert.assertEquals(expectedMetin,actualIcMetin);

       // Assert.assertTrue(expectedMetin.contains(actualIcMetin));
       // Assert.assertTrue(driver.findElement(By.xpath("//h1[.='Applications lists']")).isDisplayed());


        //        Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        //        Ana sayfadaki Povered By yazinisi test etmek istiyorum Ama driver hala iframein icinde
        //        Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame

       // driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        String footerTest=driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerTest);
        Assert.assertTrue(footerTest.contains("Povered By"));


    }
}
