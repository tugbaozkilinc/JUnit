package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Homework03 extends TestBase {

    @Test
    public void test01() {
        // “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // “Our Products” butonuna basin
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        // “Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();
        waitFor(3);

        // Popup mesajini yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@class='modal-body']")).getText());

        // “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        // "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();

        // "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertEquals("http://webdriveruniversity.com/index.html", driver.getCurrentUrl());
    }

}
