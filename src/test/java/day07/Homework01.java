package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Homework01 extends TestBase {

    @Test
    public void simpleAlertTest() {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult);

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actualResult1 = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult1 = "successfuly";
        Assert.assertFalse(actualResult1.contains(expectedResult1));

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Tugba");
        driver.switchTo().alert().accept();
        String actualResult2 = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult2 = "Tugba";
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }

}
