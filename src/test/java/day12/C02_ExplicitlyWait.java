package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {

    // Note: Bir sayfanın uygulama sunucusu veya web sunucusu çok yavaşsa veya internet ağı çok yavaşsa, web sayfasındaki öğe(webelement) çok yavaş yüklenir.
    // Bu durumda, komut dosyanız(test script) öğeyi bulmaya çalıştığında, öğeler yüklenmez. Bu yüzden test komut dosyası(test script) öğeyi bulamaz ve başarısız
    // olur ve NoSuchElement Exception alırız. Driver ile cihaz veya internet arasinda yasanan senkronizasyon sorunlarini çözmek icin sürücümüzü(driver) belli sartlar
    // ile bekletmemiz(wait) gerekir.
    // 1. Java tabanli wait;
    // Thread.sleep : Javadan gelir ve kodlari yazilan sure kadar bekletir. Sure dolduktan sonra alt satirdan isleme devam eder.
    // 2. Selenium tabanli wait’ler;
    // Selenium tabanli wait’lerde verilen sure max. bekleme suresidir, islem daha once biterse surenin  bitmesi beklenmez, kod calismaya devam eder.
    // Implicitly Wait: Sayfadaki tüm öğeler için global bir zaman aşımıdır(timeout). Genellikle otomasyon frameworklerinde olasi senkronizasyon problemleri icin
    // default olarak implicitly wait kullanilir.
    // Explicitly Wait: Çoğunlukla nadiren karsimiza cikan ve daha fazla bekleme süresi gerektiren belirli öğeler için belirli bir koşul(expected condition) için kullanılır.
    // Implicitly wait ile cozulebilecek durumlar icin explicitly wait kullanimina ihtiyac yoktur.
    // Fluent wait:

    @Test
    public void explicitlyWaitTest() {
        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        // Hello World! Yazının sitede oldugunu test et
        // Note: implicitlyWait Sayfa daki web element lerin yüklenmesi için bekliyor ama içerde bir butona basınca loading yani bekleme yaparken çalışmıyor.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!", helloWorldText);
    }

}