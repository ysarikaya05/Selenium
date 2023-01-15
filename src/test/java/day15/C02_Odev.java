package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.TestBase;

import java.util.List;

public class C02_Odev extends TestBase {

    //https://the-internet.herokuapp.com/tables
    //Create a class: WebTables
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’ datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin
    //Co


    @Test
    public void webTables1() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("table1 = " + table1.getText());

    }

    @Test
    public void row3PrintTest() {

        //Task 2 : 3. Row’ datalarını print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement row3print = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[3]"));
        System.out.println("row3print = " + row3print.getText());

    }

    @Test
    public void row4Test() {

        //Task 3 : Son row daki dataları print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement row4Print = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[4]"));
        System.out.println("row4Print = " + row4Print.getText());


    }

    @Test
    public void columDatalariTest() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        for (WebElement row5Print :sutun5){
            System.out.println("row5Print.getText() = " + row5Print.getText());
        }
    }
}