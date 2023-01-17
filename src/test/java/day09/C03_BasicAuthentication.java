package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {

    // Authentication: Kimlik dogrulama.
    // Authentication Nedir?
    // Kısaca, herhangi bir internet kullanıcısının, uygulamanın ya da programın, söz konusu sisteme dahil olup olamayacağını belirleyen formu ifade eder.
    // Uygulama ana sayfalarindaki kullanici adi ve password istemek de bir authentication’dir. Bu authentication’i yapabilmek icin uygulamanin kullanicilara
    // authentication’i nasil yapacagina dair bilgilendirme yapmis olmasi gerekir. Ornegin asagidaki uygulama icin authentication asagidaki gibi yapilabilir.

    @Test
    public void basicAuthenticationTest() {
        // https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); // authentication url
        // Note: Manuel olarak user name i password u girdik ve sayfaya giris sagladik fakat inspect yapamiyoruz Alert te oldugu gibi.(alert te tek box oldugu icin metin gonderebiliyorduk
        // fakat burda iki tane box oldugu icin gonderemiyoruz, bu yuzden handle etmeliyiz.)

        // Asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        // URL         : https://username:password@URL
        // Username    : admin
        // password    : admin
        waitFor(3000);
        String actualText = driver.findElement(By.xpath("//p")).getText();

        // Basarili sekilde sayfaya girin ve ‘Congratulations!’ yazisini doğrulayın.
        Assert.assertTrue(actualText.contains("Congratulations!"));
    }

}
