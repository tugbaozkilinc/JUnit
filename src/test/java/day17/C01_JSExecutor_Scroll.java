package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutor_Scroll extends TestBase {

    // Excel Okuma
    // Excelden veriyi okumak icin hangi sırayla gitmem gerekir
    // workbook > sheet > row > cell
    // Bir exceldeki top satir sayısı nasıl bulunur?
    // getLastRowNumber
    // Ya da
    // getPhysicalNumberOfRows- toplam kullanılan satir sayısı
    // Excel Yazdırma
    // Microsoft dosyalari ile iletişime gecmek icin apache poi dependencies kullanılır
    // Su anki projende exceli nasil kullandin?
    // Test caselerimde çeşitli datalar kullanıyorum. Ornegin kullanıcı adi, kullanıcı şifresi gibi dataları excelde tutuyoruz. Bu datalari test caselerde kullanmak icin
    // excelden çekiyorum ve test caselerimde kullanıyorum.
    // Datalari excelde tutmanın faydası, dataların derli toplu bir yerde olması, data güvenliği, data kayıplarına engel olmak.

    // JavaScript HTML kodlara direk erişip yönetebilen bir script dili olduğundan bize çok fazla kolaylık sağlayabilir.

    @Test
    public void scrollIntoViewTest() {
        // Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(2);

        // We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
        WebElement element = driver.findElement(By.xpath("//*[text()='we offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element); // arguments[0].scrollIntoView(true) belirli bir elemente scroll yapmak icin kullanilir.
        waitFor(3);
        takeScreenShotOfPage();

        // Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enroll = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        scrollIntoViewJS(enroll);
        waitFor(3);
        takeScreenShotOfPage();

        // Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        scrollIntoViewJS(whyUs);
        waitFor(3);
        takeScreenShotOfPage();

        // Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(enroll);
        takeScreenShotOfPage();

        // En uste git
        scrollTopJS();
        waitFor(3);

        // En alta git
        scrollEndJS();
        waitFor(3);
    }

}
