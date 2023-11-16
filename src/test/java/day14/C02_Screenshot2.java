package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshot2 extends TestBase {

    @Test
    public void screenshotOfSpecificElements() throws IOException {
        //Techpro education a git
        driver.get("https://www.techproeducation.com");

        //Sosyal medya elemanlarının goruntusunu al
        WebElement element = driver.findElement(By.xpath("//*[@data-id='d7545f2']"));
        File image = element.getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentDate + "image.png";
        FileUtils.copyFile(image, new File(path));

        //Logonun ekran goruntusunu al
        takeScreenshotOfElement(driver.findElement(By.xpath("//a[@title='Online IT Courses']")));
    }

}
