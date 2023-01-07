package tekrar_day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilites.TestBase;

import java.util.Set;

public class C04 extends TestBase {

    @Test
    public void handleCookiesTest() {

        //1.Amazona git
        driver.get("https://www.amazon.com");
        waitFor(3);

        //2.Toplam cookies sayisini bulalim
        Set<Cookie> allCookies = driver.manage().getCookies();
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada " + cookieSayisi + "adet var");

        //3.Bir Cookie yi smiyle bul.
        //Tum cookieleri yazdiralim
        // allCookies.stream().forEach(t-> System.out.println(t.getName()));
        for (Cookie eachCookie : allCookies) {
            System.out.println("COOKIE :" + eachCookie);
            System.out.println(eachCookie.getName());

        }
        System.out.println("COOKIEYI ISMIYLE CAGIRIYORUM: " + driver.manage().getCookieNamed("i18n-prefs"));

        //4.Yeni bir ccokie ekle
        Cookie favoriCookiem = new Cookie("cikolatam", "antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookiem);
        waitFor(3);
        System.out.println("Yeni Cookie Sayisi: " + driver.manage().getCookies().size());

        //5. Bir cookiyi sil
        driver.manage().deleteCookieNamed("session-id");

        //6.tum cookileri sil
        driver.manage().deleteAllCookies();
        waitFor(3);
        System.out.println("TUM COOKILERİ SILDIM.YENI COOKIE SAYISI:"+ driver.manage().getCookies().size());



    }
}
