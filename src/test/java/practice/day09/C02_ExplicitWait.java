package practice.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    @Test
    public void name() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! yazısının çıktığını doğrulayalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4"))); //Hello World! yazisi gorunene kadar bekle
        //Assert.assertTrue(element.isDisplayed());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']"))); //loading kaybolana kadar bekle
        Assert.assertTrue(driver.findElement(By.xpath("//h4")).isDisplayed());
    }

}
