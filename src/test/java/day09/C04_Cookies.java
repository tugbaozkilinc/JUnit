package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest() {

        // Cookies, belirli kullanıcıları tanımlamak ve bu kullanıcıların göz atma deneyimini iyileştirmek için kullanıcının bilgisayarı ile web sunucusu
        // arasında takas edilen, kullanıcı adı ve parola gibi küçük veri parçalarını içeren dosyalardır. İnternette gezinirken ziyaret ettiğiniz web sayfaları,
        // bilgisayarınıza ve telefonunuza küçük bilgi dosyaları kaydeder. Bu dosyalar telefon veya bilgisayarınızın hafızasında saklanır. Daha sonra aynı siteleri ziyaret
        // ettiğinizde bu kayıtlı bilgi dosyaları sayesinde siteler sizi tanıyabilir.

        //1. Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);

        //2. Toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();
        int cookiesNumber = allCookies.size();
        System.out.println("All cookies number is: " + cookiesNumber);

        //3. Bir Cookie yi ismiyle bul
        allCookies.forEach(t -> System.out.println("Cookies: " + t));
        allCookies.forEach(t -> System.out.println("Cookies name is: " + t.getName()));
        System.out.println(driver.manage().getCookieNamed("i18n-prefs"));

        //4. Yeni bir cookie ekle
        Cookie cookie = new Cookie("chocolate-chip", "white");
        driver.manage().addCookie(cookie);
        waitFor(3);
        System.out.println("New cookies number is:" + driver.manage().getCookies().size());

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(3);
        System.out.println("After deleting cookies number is: " + driver.manage().getCookies().size());
        // NOTE: Tum bu islemler gecicidir. Actigimiz browser daki cookie leri sildik ve yeni cookie olusturduk. Yeni bir browser actiginda hersey sifirdan baslar.
    }

}
