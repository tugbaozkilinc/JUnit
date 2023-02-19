package day07;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Homework04 extends TestBase {

    @Test
    public void iframeTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> list = driver.findElements(By.tagName("iframe"));
        System.out.println("The sum of the iframes is: " + list.size());

        //Sayfa basliginda ‘Editor’ yazısinı içermediğini test edelim.
        Assert.assertFalse(driver.getTitle().contains("Editor"));

        //Paragrafdaki yaziyi silelim.
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//p[text()='Your content goes here.']")).clear();

        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım.
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("iframein icindeyim");
        Thread.sleep(2000);

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        String element = driver.findElement(By.linkText("Elemental Selenium")).getText();
        Assert.assertTrue(element.contains("Elemental Selenium"));
    }

}
