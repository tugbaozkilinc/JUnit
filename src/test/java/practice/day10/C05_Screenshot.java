package practice.day10;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class C05_Screenshot extends TestBase {

    @Test
    public void screenshotTest() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //Tüm sayfanın resmini alalım
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentDate + ".jpeg";
        FileUtils.copyFile(image, new File(path));

        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        takeScreenShotOfPage();

        //Tekrar amazon sayfasına dönüp iphone aratalım
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(0));
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //Arama sonucunun resmini alalım
        takeScreenshotOfElement(driver.findElement(By.xpath("//*[text()='1-16 of 170 results for']")));
    }

}
