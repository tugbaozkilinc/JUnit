package practice.day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P02 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // - https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String firstWindowHandle = driver.getWindowHandle();

        // - youtube videosunu çalıştırınız
        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);

        // - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();

        // - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        // - iphone aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        // - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String[] arr = driver.findElement(By.xpath("//span[text()='1-16 of 144 results for']")).getText().split(" ");
        System.out.println("The result number is: " + arr[2]);

        // - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(firstWindowHandle);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current url is: " + currentUrl);

        // - ilk sekmeyi kapatalım.
        driver.close();

        // - Sonra diğer sekmeyide kapatalım.
    }

}
