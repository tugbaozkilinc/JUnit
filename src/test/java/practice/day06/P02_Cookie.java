package practice.day06;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;
import java.util.Set;

public class P02_Cookie extends TestBase {

    @Test
    public void test01() {
        //Techproeducation adresine gidiniz
        driver.get("https://www.techproeducation.com");
        waitFor(5);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies size is: " + cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        cookies.forEach(t -> System.out.println(t.getName() + ": " + t.getValue()));

        //Yeni bir cookie ekleyiniz
        Cookie cookie = new Cookie("white", "chocolate");
        driver.manage().addCookie(cookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> newCookies = driver.manage().getCookies();
        System.out.println("Cookies size is: " + newCookies.size());
        newCookies.forEach(t -> System.out.println(t.getName() + ": " + t.getValue()));

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookieNamed("white"); //driver.manage().deleteCookie(cookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies().size());
    }

}
