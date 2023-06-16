package practice.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class C03_DownloadFile extends TestBase {

    @Test
    public void downloadTest() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        String firstWindowHandle = driver.getWindowHandle();

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browsers = driver.findElement(By.xpath("(//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(browsers).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browsers.click();
        waitFor(2);
        WebElement chrome = driver.findElement(By.xpath("(//*[text()='documentation'])[5]"));
        chrome.click();

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("//*[text()='ChromeDriver 110.0.5481.30']")).click();

        //Açılan pencerede chromedriver'i indirelim
        Set<String> list = driver.getWindowHandles();
        list.stream().filter(t -> !t.equals(firstWindowHandle)).forEach(t -> System.out.println(driver.switchTo().window(t)));

        //Driver'in indiğini doğrulayalım
        WebElement element = driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']"));
        element.click();
        waitFor(2);
        String path = System.getProperty("user.home") + "\\Downloads\\chromedriver_win32.zip";
        boolean isDownloaded = Files.exists(Paths.get(path));
        Assert.assertTrue(isDownloaded);
    }

}
