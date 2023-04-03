package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    @Test
    public void uploadFileTest() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        String path = System.getProperty("user.home") + "\\Desktop\\logo.jpeg";
        chooseFileButton.sendKeys(path);
        waitFor(5);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }

}
