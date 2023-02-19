package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class Homework08 extends TestBase {

    @Test
    public void test01() {
        //url'ye git: https://demo.guru99.com/popup.php
        driver.get("https://demo.guru99.com/popup.php");

        //ilk pencereyi al
        String firstWindowHandle = driver.getWindowHandle();

        //"Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[@target='_blank']")).click();

        //setteki tüm pencereyi al, diğer pencereye geç
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.stream().filter(t -> !t.equals(firstWindowHandle)).forEach(t -> driver.switchTo().window(t));

        //e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın Gönder düğmesine tıklayarak
        driver.findElement(By.name("emailid")).sendKeys("somepne@gmail.com", Keys.TAB, Keys.ENTER);

        //""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String actualText = driver.findElement(By.xpath("//*[text()='This access is valid only for 20 days.']")).getText();
        String expectedText = "This access is valid only for 20 days.";
        Assert.assertEquals(expectedText, actualText);

        //Tekrar ilk pencereye geç
        driver.switchTo().window(firstWindowHandle);

        //İlk pencerede olduğunu doğrula
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.guru99.com/popup.php";
        Assert.assertEquals(expectedUrl, actualUrl);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Guru99 Bank']")).isDisplayed());
    }

}
