package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    /*
    TimeOutException:
    TimeOutException explicit wait kullanıldığında ve element bulunamadığında alınan bir hatadır.
    Şimdiye kadar karşılaşmamamızın nedeni sadece implicit wait kullanmış olmamızdır.
    Explicit wait ve yanlış locatar kullandığımız zaman TimeOutException alırız.
    Explicit wait var, doğru locatar kullandık ama süre yeterli olmadığı durumlarda TimeOutException alırız.
    Explicit wait var, doğru locatar kullandık, süre yeterli ama iframe var TimeOutException alırız.
    Çözüm:
    - Süreyi arttırabiliriz.
    - Farkli explicit wait yöntemleri kullanırız. Örn: visibilityOfElementLocated yerine presenceOfElementLocated kullanabiliriz.
      Ya da javascript executor daki waitleri sayfa geçişlerini beklemek için kullanabiliriz.
    - Locator ı kontrol ederiz.
    - Framework umde hazır reusable method lar var. Bu durumda TimeOutException aldığımda o methodlar yardımıyla problemi çözebiliriz.
    */

    @Test
    public void timeOutExceptionTest() {
        driver.get("https://www.techproeducation.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Yanlıs ID")));
        //Explicit wait kullandığımız için ve locator da hatalı olduğu için TimeOutException hatası alıyoruz.
    }

}
