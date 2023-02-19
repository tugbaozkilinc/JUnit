package practice.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P03 extends TestBase {

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String firstWindowHandle = driver.getWindowHandle();

        //An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement text = driver.findElement(By.xpath("//p"));
        text.clear();
        text.sendKeys("Techproeducation");

        //TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).isDisplayed());

        //Elemental Selenium linkine tıklayın
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //Açılan sayfada sayfa başlığını yazdırınız
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        // for (String w : driver.getWindowHandles()){
        //     if (!w.equals(firstWindowHandle)){
        //         driver.switchTo().window(w);
        //     }
        // }
        String elementalTitle = driver.getTitle();
        System.out.println("Current title is: " + elementalTitle);

        //Elemental Selenium başlığı altındaki "Sauce Labs" linkinin gorunur olduğunu test edin
        WebElement sourceLabsElement = driver.findElement(By.xpath("//a[text()='Sauce Labs']"));
        Assert.assertTrue(sourceLabsElement.isDisplayed());

        //Source labs linkine tıklayın
        sourceLabsElement.click();

        //Açılan sayfada sayfa başlığını yazdırınız
        List<String> newWindowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newWindowHandles.get(2));
        String crossBrowserTitle = driver.getTitle();
        System.out.println("Current title is: " + crossBrowserTitle);

        //ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(newWindowHandles.get(0));
        System.out.println("Current url is: " + driver.getCurrentUrl());

        //ilk sekmeyi kapatalım
        driver.close();
    }

}
