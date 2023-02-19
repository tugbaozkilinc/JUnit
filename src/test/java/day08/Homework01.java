package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Homework01 extends TestBase {

    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String windowHandle = driver.getWindowHandle();

        //Title in ‘Windows’ oldugunu test edin.
        Assert.assertEquals("Windows", driver.getTitle());

        //Click here a tiklayin.
        driver.findElement(By.linkText("Click Here")).click();

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin.
        for (String w : driver.getWindowHandles()){
            if(!w.equals(windowHandle)){
                driver.switchTo().window(w);
                break;
            }
        }
        Assert.assertEquals("New Window", driver.getTitle());
    }

}
