package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Homework01 extends TestBase {

    @Test
    public void fileDownloadTest() {
        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // LambdaTest.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='LambdaTest.txt']")).click();
        waitFor(3);

        // Dosyanın başarıyla indirilip indirilmediğini test edelim
        String path = System.getProperty("user.home") + "\\Downloads\\LambdaTest.txt";
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }

}
