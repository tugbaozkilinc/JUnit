package practice.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    @Test
    public void test01() {
        // 1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();
        waitFor(5);

        // 3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        String path = "C:\\Users\\tugba\\Downloads\\some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }

}
