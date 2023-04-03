package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Homework01 extends TestBase {

    @Test
    public void waitTest1() {
        explicitWait();
    }

    @Test
    public void waitTest2() {
        fluentWait();
    }

    public void explicitWait(){
        //Iki tane method olusturun: fluentWait(), explicitWait()
        //Iki method icin de asagidaki adimlari test edin.
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(element.isDisplayed());

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(webElement.isDisplayed());
    }

    public void fluentWait(){
        //Iki tane method olusturun: fluentWait(), explicitWait()
        //Iki method icin de asagidaki adimlari test edin.
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(3)).withMessage("Ignore Exception").ignoring(NoSuchMethodException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(element.isDisplayed());

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(webElement.isDisplayed());
    }

}
