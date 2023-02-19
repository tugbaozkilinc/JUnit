package practice.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandles extends TestBase {

    @Test
    public void test01() {
        //'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");

        //arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("oppo", Keys.ENTER);

        //ilk ürüne tıklayın
        driver.findElement(By.xpath("//*[@id='p-493285594']")).click();

        //Basligin 'Oppo' icerdigini test edin.
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='proName']")).getText().contains("Oppo"));

        //ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(windowHandles.get(0));
        System.out.println(driver.getTitle());
    }

}
