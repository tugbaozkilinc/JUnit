package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Homework10 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        String window1Handle = driver.getWindowHandle();

        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@stroke='currentColor'])[3]")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text = driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(text.isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTabElement = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTabElement.isDisplayed());

        //New Tab butonuna click yap
        newTabElement.click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        for (String w : driver.getWindowHandles()){
            if (!w.equals(window1Handle)){
                driver.switchTo().window(w);
                break;
            }
        }
        WebElement textNewPage = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(textNewPage.isDisplayed());

        //İlk Tab'a geri dön
        driver.switchTo().window(window1Handle);

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTab.isDisplayed());
    }

}
