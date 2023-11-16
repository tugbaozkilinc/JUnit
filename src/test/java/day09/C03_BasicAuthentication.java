package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {

    //Authentication: Kimlik dogrulama.
    //Authentication Nedir?
    //Kısaca, herhangi bir internet kullanıcısının, uygulamanın ya da programın, söz konusu sisteme dahil olup olamayacağını belirleyen formu ifade eder.
    //Uygulama ana sayfalarindaki kullanici adi ve password istemek de bir authentication’dir. Bu authentication’i yapabilmek icin uygulamanin kullanicilara
    //authentication’i nasil yapacagina dair bilgilendirme yapmis olmasi gerekir. Ornegin asagidaki uygulama icin authentication asagidaki gibi yapilabilir.

    @Test
    public void basicAuthenticationTest() {
        //Asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //URL         : https://username:password@URL
        //Username    : admin
        //password    : admin
        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); //authentication url
        waitFor(3);

        //Basarili sekilde sayfaya girin ve ‘Congratulations!’ yazisini doğrulayın.
        String actualText = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(actualText.contains("Congratulations!"));
    }

}
