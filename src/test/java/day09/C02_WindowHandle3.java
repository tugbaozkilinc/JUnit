package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest() {
        // 1. TechPro education sayfasinin title'inin "Techpro Education" metnini icerdigini test edin.
        driver.get("https://techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        // 2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://wwww.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        // 3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        // techproeducation sayfasina gidiniz.
        waitFor(3);
        switchToWindow(0);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
    }

}
