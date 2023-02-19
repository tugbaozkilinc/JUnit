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
    //Seleniumdan gelen ve javascript kodlarını calistirmaya yarayan bir interface dir. Normal selenium metotları yeterli olmadıgı durumlarda kullanilabilir.
    //Ne zaman ve nasıl kullandın?
    //Normal selenium metotları yeterli olmadıgı durumlarda kullanilabilir. Ornegin, bazı buttonlara tıklamada problem olabiliyor, ya da belirli bir web elementin gorunur olacağı
    //sekilde sayfanın kaydırma islemi, yada input kutularindaki değerleri almak icin kullanilabilir.
    //Sayfayi asagi veya yukarı kaydırma islemi seleniumda nasıl yapılır?
    //Seleniumdaki Actions yada javascript executor metotları ile kaydırma islemleri yapılabilir. Ornegin, actionslarda page_up, page_down, arrow_up, arrow_down metotlari ile yada js executordaki scrollintoview(true) ile yapılabilir. Ben olusturdugumuz reusable metotlarını kullanarak bu islemlile kolaylıkla yapabiliyorum
    //Bir kutucukdaki(input) elemanın metni nasıl alınabilir?
    //Javascript executor ile alabiliriz. Cunki js executor ile attribute degerlerini alma imkanımız var. getText() METORU BU DURUMLARDA CALISMAZ.
    //Selenium da click yaparken problem yasadigin oldu mu?
    //Bazen yanlis locator, yada bekleme(wait) problemi gibi durumlarda problem yaşadım. Bazen gizli(hidden) elementlere tiklarkende problem yaşadım. Bu durumlarda javascript executor kullandım ve problemi cozdum.
    //Selenium atomayonunda ne tur problemler yaşadın?
    //TEKNIK PROBLEMLER :Yanlis locator,bekleme(wait), alert, iframe, captcha, pop-up seklindeki reklam bildirimleri,multiple window, hidden elementlere tiklama, …
    //TAKIMLA ILGILI PROBLEMLER: (Çok gundeme getirilmemeli). Developer bazen bulduğum hatalari kabul etmiyordu. Cozum: takımla beraber değerlendirip fikir birliğine variyorduk.

}
