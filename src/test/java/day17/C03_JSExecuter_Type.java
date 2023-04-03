package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {

    @Test
    public void typeTest() {
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");

        //Arama kutusuna QA yaz
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', 'QA');", driver.findElement(By.xpath("//input[@type='search']"))); //Sadece tag i input olanlar icin gecerli.
        //js.executeScript("arguments[0].value='QA'", searchBox);
    }

    //Javascript Executor nedir?
    //Seleniumdan gelen ve javascript kodlarını calistirmaya yarayan bir interface dir. Normal selenium method ları yeterli olmadıgı durumlarda kullanilabilir.
    //Ne zaman ve nasıl kullandın?
    //Normal selenium method ları yeterli olmadıgı durumlarda kullanilabilir. Ornegin, bazı buttonlara tıklama da problem olabiliyor, ya da belirli bir web elementin gorunur olacağı
    //sekilde sayfanın kaydırma islemi, ya da input kutularindaki değerleri almak icin kullanilabilir.
    //Sayfayi asagi veya yukarı kaydırma islemi seleniumda nasıl yapılır?
    //Seleniumdaki Actions yada javascript executor method ları ile kaydırma islemleri yapılabilir. Ornegin, actions larda page_up, page_down, arrow_up, arrow_down method lari ile ya da
    //js executor daki scrollintoview(true) ile yapılabilir. Ben olusturdugumuz reusable method larını kullanarak bu islemleri kolaylıkla yapabiliyorum
    //Bir kutucukdaki(input) elemanın metni nasıl alınabilir?
    //Javascript executor ile alabiliriz. Cunku js executor ile attribute degerlerini alma imkanımız var. getText() METHOD U BU DURUMLARDA CALISMAZ.
    //Selenium da click yaparken problem yasadigin oldu mu?
    //Bazen yanlis locator, ya da bekleme(wait) problemi gibi durumlarda problem yaşadım. Bazen gizli(hidden) elementlere tiklarken de problem yaşadım. Bu durumlarda javascript executor
    //kullandım ve problemi cozdum.
    //Selenium automation da ne tur problemler yaşadın?
    //TEKNIK PROBLEMLER :Yanlis locator, bekleme(wait), alert, iframe, captcha, pop-up seklindeki reklam bildirimleri, multiple window, hidden elementlere tiklama, …
    //TAKIMLA ILGILI PROBLEMLER: (Çok gundeme getirilmemeli). Developer bazen bulduğum hatalari kabul etmiyordu. Cozum: takımla beraber değerlendirip fikir birliğine variyorduk.

}
