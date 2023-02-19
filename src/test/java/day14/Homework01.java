package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework01 extends TestBase {

    @Test
    public void test01() throws IOException {
        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        waitFor(2);

        //amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        Assert.assertEquals("https://www.amazon.com/", driver.getCurrentUrl());
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentDate + "image.png";
        FileUtils.copyFile(image, new File(path));

        //Nutella icin arama yapin
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella", Keys.ENTER);

        //sonucun Nutella icerdigini test edin  ve ilk urunun goruntusunu alin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("Nutella"));
        File secondImage = driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(secondImage, new File(path));
    }

}
