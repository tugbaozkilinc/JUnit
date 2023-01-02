package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Homework07 extends TestBase {

    @Test
    public void windowHandleTest() {
        // Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        // Sayfa’nin window handle degerini String bir degiskene atayin.
        String amazonWindowHandle = driver.getWindowHandle();

        // Sayfa title’nin “Amazon” icerdigini test edin.
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

        // Sayfa title’nin “Techpro Education” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        // Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertEquals("https://www.amazon.com/", driver.getCurrentUrl());
    }

}
