package practice.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P01 extends TestBase {

    @Test
    public void test01() {
        // Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        // Sayfa’nin window handle degerini String bir degiskene atayin.
        String firstWindowHandle = driver.getWindowHandle();

        // Sayfa title’nin “Amazon” icerdigini test edin.
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));

        // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

        // Sayfa title’nin “Techpro Education” icerdigini test edin
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        // Sayfa title’nin “Walmart” icerdigini test edin
        String walmartTitle = driver.getTitle();
        Assert.assertTrue(walmartTitle.contains("Walmart"));

        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin.
        driver.switchTo().window(firstWindowHandle);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.amazon.com/", currentUrl);
    }

}
