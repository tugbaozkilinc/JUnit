package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Homework01 extends TestBase {

    @Test
    public void explicitlyWait() {
        // Iki tane method olusturun : implicitlyWait(), explicitlyWait()
        // Iki method icin de asagidaki adimlari test edin.
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']")).click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(element.isDisplayed());

        // Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // It’s back mesajinin gorundugunu test edin
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(webElement.isDisplayed());
    }

}
