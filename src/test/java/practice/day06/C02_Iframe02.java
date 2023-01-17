package practice.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe02 extends TestBase {

    @Test
    public void name() {
        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        // TextBox'a 'Merhaba Dunya' yazin.
        driver.switchTo().frame(0);
        WebElement testBox = driver.findElement(By.xpath("//p"));
        testBox.clear();
        testBox.sendKeys("Merhaba Dunya");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='text-align: center;']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[@style='text-align: center;']")).getText());
    }

}
