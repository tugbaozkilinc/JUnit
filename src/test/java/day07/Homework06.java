package day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Homework06 extends TestBase {

    @Test
    public void iframeTest() throws InterruptedException {
        // http://demo.guru99.com/test/guru99home/ sitesine gidiniz.
        driver.get("http://demo.guru99.com/test/guru99home/");

        // Sayfadaki iframe sayısını bulunuz.
        List<WebElement> list = driver.findElements(By.xpath("//iframe"));
        System.out.println("The number of iframe is: " + list.size());

        // ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(0);
        //driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        Thread.sleep(2000);

        // ilk iframe'den çıkıp ana sayfaya dönünüz.
        // ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız.
    }

}
