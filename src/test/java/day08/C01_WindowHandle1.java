package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {

    @Test
    public void handleWindowTest() throws InterruptedException {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle = driver.getWindowHandle();

        // Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String window1ActualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", window1ActualText);

        // Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String window1ActualTitle = driver.getTitle();
        Assert.assertEquals("The Internet", window1ActualTitle);

        // Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        // Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String w : allWindowHandles){
            if (!w.equals(window1Handle)){
                driver.switchTo().window(w);
                break;
            }
        }
        // allWindowHandles.stream().filter(t->!t.equals(window1Handle)).forEach(t->driver.switchTo().window(t));
        String window2ActualTitle = driver.getTitle();
        Assert.assertEquals("New Window", window2ActualTitle);

        // Sayfadaki textin "New Window" olduğunu doğrulayın.
        String window2ActualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", window2ActualText);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        String window2Handle = driver.getWindowHandle();
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());

        // 2. window a tekrar gecelim.
        driver.switchTo().window(window2Handle);

        // 1. window a tekrar gecelim.
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);
    }

}
