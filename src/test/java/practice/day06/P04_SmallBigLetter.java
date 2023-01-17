package practice.day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04_SmallBigLetter extends TestBase {

    @Test
    public void test01() {
        // Google sayfasina gidelim
        driver.get("https://www.google.com");

        // Buyuk kucuk harf olacak sekilde HeLlo yazdiralim
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT, "h", Keys.SHIFT, "e", Keys.SHIFT, "l", Keys.SHIFT, "l", "o");
    }

}
