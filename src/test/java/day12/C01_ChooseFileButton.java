package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBase;

public class C01_ChooseFileButton extends TestBase {

    @Test
    public void UploadFile() {

        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";
        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(5);


        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String uploadedYazisi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!", uploadedYazisi);
        waitFor(3);
    }

    @Test
    public void chooseFileButton() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        WebElement chooseFile = driver.findElement(By.cssSelector("[id='file-upload']"));
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";
        chooseFile.sendKeys(dosyaYolu);
        waitFor(3);

        //Upload butonuna basalim.
        driver.findElement(By.cssSelector("[id='file-submit']")).click();
        waitFor(5);

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String actualFileUplauded=driver.findElement(By.xpath("//h3")).getText();
        String expectedFileUplauded="File Uploaded!";
        Assert.assertEquals(actualFileUplauded,expectedFileUplauded);



    }
}
