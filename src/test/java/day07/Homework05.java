package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Homework05 extends TestBase {

    @Test
    public void iframeTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve	konsolda yazdirin.
        String outerText = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("Outer text is: " + outerText);
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());

        //Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//p[text()='Your content goes here.']")).clear();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Merhaba Dunya!");
        Thread.sleep(2000);

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().parentFrame();
        WebElement element = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(element.isDisplayed());
    }

}
