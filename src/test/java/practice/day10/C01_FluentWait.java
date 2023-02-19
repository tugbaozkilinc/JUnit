package practice.day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me, to open an ... butonuna basalım
        WebElement element = driver.findElement(By.xpath("//*[@id='alert']"));
        element.click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent()); //Alert cikana kadar bekle

        //Çıkan alert'i kapatalım
        driver.switchTo().alert().accept();
    }

}
