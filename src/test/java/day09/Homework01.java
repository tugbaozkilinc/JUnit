package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Homework01 extends TestBase {

    @Test
    public void test01() {
        // 1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        waitFor(2);

        // 2-Tum cookie’leri listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(t -> System.out.println("Cookies: " + t));

        // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookies number is: " + cookies.size());
        Assert.assertTrue(cookies.size()>5);

        // 4-Ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD", actualValue);

        // 5-Ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin.
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);
        waitFor(2);

        // 6-Eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertEquals(9, driver.manage().getCookies().size());

        // 7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertEquals(8, driver.manage().getCookies().size());

        // 8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Assert.assertEquals(0, driver.manage().getCookies().size());
    }

}
