package practice.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Upload extends TestBase {

    @Test
    public void uploadTest() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        WebElement uploadButton = driver.findElement(By.id("uploadfile_0"));
        String path = System.getProperty("user.home") + "\\Desktop\\Kitap1.xlsx"; //Dinamik code
        uploadButton.sendKeys(path);

        //I accept terms of service bölümünü tiklayin
        driver.findElement(By.xpath("//*[@id='terms']")).click();

        //Submit File buttonuna basınız
        driver.findElement(By.xpath("//*[@id='submitbutton']")).click();

        //"1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(2);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='formbuttons'])[2]")).isDisplayed());
    }

}
