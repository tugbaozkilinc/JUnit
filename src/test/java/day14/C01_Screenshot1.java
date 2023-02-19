package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {

    //Selenium tum ekran goruntusu nasil alinir?
    //-tum ekran goruntusu seleniumdan gelen getScreenshotAs method u ile alinir.
    //-getScreenshotAs method u selenium daki TakesScreenshot api indan gelir.
    //2 farkli sekilde ekran goruntusu alinabilir; tum sayfa, ozel element
    //Olusturmus oldugum reusable method yardımıyla ister tum sayfanin ister belirli bir elementin ekran goruntusunu kolaylikla alabilirim.
    //Note: Interview da tek tek syntax leri anlatma, sohbet ortaminda gecer daha cok.

    @Test
    public void fullPageScreenshotTest() throws IOException {
        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");
        //1. Ekran goruntusunu getScreenshotAs method u ile alip File olarak olusturalim.
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //2. Almis oldugum ekran goruntusunu belirledigim bir PATH e kaydet (.dir=directory=dosya)
        //Note: kayit ismini dinamik yapmak icin date objesi kullandim.
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentDate + "image.png";
        File target = new File(path);
        //3. Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(image, target);
        //ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
        //FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), //goruntu
        //new File(System.getProperty("user.dir") + "/test-output/Screenshots/" + currentDate + "image.png")); //path

        //“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA", Keys.ENTER);
        waitFor(3);

        //Sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String text = driver.findElement(By.xpath("//*[text()='Search Results for: QA']")).getText();
        Assert.assertEquals("Search Results for: QA", text);
        takeScreenShotOfPage();
    }

}
