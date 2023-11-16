package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutor_Scroll extends TestBase {

    //-JavascriptExecutor nedir?
    //Seleniumdan gelen ve javascript kodlarını calistirmaya yarayan bir interface dir. Normal selenium method ları yeterli olmadıgı durumlarda kullanilabilir.
    //-Ne zaman ve nasıl kullandın?
    //Normal selenium method ları yeterli olmadıgı durumlarda kullanilabilir. Ornegin, bazı buttonlara tıklama da problem olabiliyor, ya da belirli bir web elementin gorunur olacağı
    //sekilde sayfanın kaydırma islemi, ya da input kutularindaki değerleri almak icin kullanilabilir.
    //-Sayfayi asagi veya yukarı kaydırma islemi seleniumda nasıl yapılır?
    //Seleniumdaki Actions yada javascript executor method ları ile kaydırma islemleri yapılabilir. Ornegin, actions larda page_up, page_down, arrow_up, arrow_down method lari ile ya da
    //js executor daki arguments[0].scrollIntoView(true); ile yapılabilir. Ben olusturdugumuz reusable method larını kullanarak bu islemleri kolaylıkla yapabiliyorum
    //-Bir kutucukdaki(input) elemanın metni nasıl alınabilir?
    //Javascript executor ile alabiliriz. Cunku js executor ile attribute degerlerini alma imkanımız var. getText() METHOD U BU DURUMLARDA CALISMAZ.
    //-Selenium da click yaparken problem yasadigin oldu mu?
    //Bazen yanlis locator, ya da bekleme(wait) problemi gibi durumlarda problem yaşadım. Bazen gizli(hidden) elementlere tiklarken de problem yaşadım. Bu durumlarda javascript executor
    //kullandım ve problemi cozdum.
    //-Selenium automation da ne tur problemler yaşadın?
    //TEKNIK PROBLEMLER :Yanlis locator, bekleme(wait), alert, iframe, captcha, pop-up seklindeki reklam bildirimleri, multiple window, hidden elementlere tiklama, …
    //TAKIMLA ILGILI PROBLEMLER: (Çok gundeme getirilmemeli). Developer bazen bulduğum hatalari kabul etmiyordu. Cozum: takımla beraber değerlendirip fikir birliğine variyorduk.

    @Test
    public void scrollIntoViewTest() {
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(2);

        //We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran goruntusunu al.
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        waitFor(3);
        takeScreenShotOfPage();

        //Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enroll = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        scrollIntoViewJS(enroll);
        waitFor(3);
        takeScreenShotOfPage();

        //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        scrollIntoViewJS(whyUs);
        waitFor(3);
        takeScreenShotOfPage();

        //Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(enroll);
        takeScreenShotOfPage();

        //En uste git
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        waitFor(3);

        //En alta git
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        waitFor(3);
    }

}
