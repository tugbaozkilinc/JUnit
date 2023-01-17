package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*
    StateElementReferenceException:
    Eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
    Sayfayı yenilediğimizde,
    Sayfada ileri geri gittiğimizde meydana gelen exception'dır.
    Çözüm:
    Element i tekrar bulmak.
    */

    @Test
    public void staleElementReferenceExceptionTest() throws Exception {
        driver.get("https://www.techproeducation.com");

        // LMS login linkine tıkla ve o sayfanın URL'inin lms içerdiğini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLoginLink.click();
        waitFor(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));
        waitFor(3);

        // Tekrar ana sayfaya gel ve LMS login sayfasına tekrar git.
        driver.navigate().back();
        waitFor(3);
        lmsLoginLink.click();

        // lmsLoginLink linkini sayfayı yeniledikten sonra tekrar kullandığımiz için StaleElementReferenceException aliyoruz.
    }

    @Test
    public void staleElementReferenceExceptionTest2() throws Exception {
        driver.get("https://www.techproeducation.com");
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLoginLink.click();
        waitFor(3);
        driver.navigate().refresh();
        waitFor(3);
        lmsLoginLink.click(); // StaleElementReferenceException hatası alıyoruz.
        // Çözüm: eski elementi tekrar locate et.
    }

}