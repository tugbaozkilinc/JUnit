package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutor_Scroll extends TestBase {

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
