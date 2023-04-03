package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    /*
    Interview Questions
    Tell me about 5 exception that you get in Selenium.
    What type of exceptions did you get in selenium?
    What is your solution?
    What type of waits do you use?
    Which wait do you prefer?
    Why do you prefer that wait?
    How do you resolve synchronization issue?

    NoSuchElementException***
    TimeOutException***
    NullPointerException***
    InvalidSelectorException
    StaleElementReferenceException***
    InvalidElementStateException
    WebDriverException***
    ElementNotIntractableException
    ElementClickInterceptedException
    InvalidArgumentException
    JavascriptException
    RemoteDriverServerException
    */

    @Test
    public void noSuchElementTest() throws Exception {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("wrong locator")).sendKeys("QA", Keys.ENTER);
        //Yanlış locator aldığımız için org.openqa.selenium.NoSuchElementException hatası ile karşılaştik.
    }

    //NoSuchElementException:
    //Yanlis locator
    //Popup, yeni pencere, iframe…
    //Sayfanin dolmasinda problemler ve yavaşlamalar olustugunda
    //Sakli olan elementler
    //Cözüm:
    //Locator in dogrulugunu tekrar kontrol et.
    //Manual test ile iframe, yeni pencere, alert…. gibi elementlerin varliğini kontrol et
    //Bekleme problemi olustugunda implicit wait in problemi cozmedigi durumda explicit wait ya da fluent wait kullanmak.

}
