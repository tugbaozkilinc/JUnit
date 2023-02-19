package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) //max bekleme suresi
                .pollingEvery(Duration.ofSeconds(3)) //deneme araliklari
                .withMessage("IGNORE EXCEPTION") //mesaj yazdirabilirim (zorunlu degil)
                .ignoring(NoSuchMethodException.class); //exception i handle et (zorunlu degil)

        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        System.out.println(helloWorldElement.getText());
        Assert.assertEquals("Hello World!", helloWorldElement.getText());
    }

}
