package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {

    // Alert(uyari, pop up) kullanıcıya bir tür bilgi vermek veya belirli bir işlemi gerçekleştirme izni istemek için ekran bildirimi görüntüleyen küçük bir mesaj kutusudur.
    // Uyarı amacıyla da kullanılabilir.(Web element degildir.)
    // HTML Alerts: Bir alert ciktiginda sag click ile inspect yapabiliyorsak html alert’dir ve extra bir isleme gerek yoktur.
    // Js Alerts: Js alerts inspect yapilamaz, ekstra isleme ihtiyac vardir.
    // Simple Alert(Click for JS Alert): Bu basit alert ekranda bazı bilgiler veya uyarılar görüntüler. Ok(tek secenek) denilerek kapatilir.
    // Confirmation Alert(Click for JS Confirm): Bu onay uyarısı bir tür işlem yapma izni ister. Alert onaylaniyorsa OK, onaylanmiyorsa Cancel butonuna basilir.
    // Prompt Alert(Click for JS Prompt): Bu Prompt Uyarısı kullanıcıdan bazı girdilerin girilmesini ister ve selenium webdriver metni sendkeys ("input….") kullanarak girilebilir.

    @Test
    public void name() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // 1. butona tıklayın
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);

        // Uyarıdaki OK butonuna tiklayın.
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // Result mesajinin “You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);
    }

    // Alertleri nasil automate edersin? How to handle alerts in selenium?
    // Alert ler javascript ile olusur. Inspect edilemezler. Oncelikle alert e switch etmemiz gerekir.

}
