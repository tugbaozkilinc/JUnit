package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {

    @Test
    public void typeTest() {
        // 1) Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");

        // 2) Arama kutusuna QA yaz
        typeWithJS(driver.findElement(By.xpath("//input[@type='search']")), "QA"); // Sadece tag i input olanlar icin gecerli
    }

}
