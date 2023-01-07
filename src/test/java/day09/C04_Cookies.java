package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilites.TestBase;

import java.net.CookieStore;
import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest() {


        driver.get("https://www.amazon.com");
        waitFor(2);

        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies(); //toplam cerez sayisini verir.
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada " + cookieSayisi + " adet cookie var");

        //3. Bir Cookie yi smiyle bul
        System.out.println("COKKIEYI ISMIYLE CAGIRIYORUM : "+driver.manage().getCookieNamed("i18n-prefs"));
        //tum cookieleri yazdiralim

       // allCookie.stream().forEach(t -> System.out.println(t.getName()));
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie:"+ eachCookie);
            System.out.println("Cookie İsimleri:"+ eachCookie.getName());
        }


//        4. Yeni bir cookie ekle
        Cookie favoriCookiem= new Cookie("cikolatam","antem-fistikli-cikolata");//cookie olustur
        driver.manage().addCookie(favoriCookiem);//sayfaya yeni cookie ekle
        waitFor(3);
        System.out.println("Yeni Cookie Sayisi : "+driver.manage().getCookies().size());//cookie sayisi artti

//        5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

//        6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : "+driver.manage().getCookies().size());
    }
}
