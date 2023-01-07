package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import utilites.TestBase;

public class SR02 extends TestBase {

    @Test
    public void name() {


        //       url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

//       ilk pencereyi al
        driver.findElement(By.cssSelector("[src='https://demo.guru99.com/images/testing-logo-1.png']")).click();

//       "Click Here" butonuna tıklayın
        driver.switchTo().frame("iframe");
        driver.findElement(By.cssSelector("[style='font-size:16px;']")).click();

//       setteki tüm pencereyi al
//       diğer pencereye geç
//       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
//       Gönder düğmesine tıklayarak
//       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
//       Tekrar ilk pencereye geç
//       İlk pencerede olduğunu doğrula

    }
}
