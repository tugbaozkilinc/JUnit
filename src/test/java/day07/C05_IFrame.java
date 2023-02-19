package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    //IFrame, bir web sayfasınin icine yerlestirilmis baska bir web sayfasıdır veya bir HTML dokumaninin içine yerleştirilmiş baska bir HTML dokumanidir.
    //IFrame genellikle bir Web sayfasına dokuman, video veya interaktif media gibi başka bir kaynaktan içerik eklemek için kullanılır.
    // //iframe bununla sayfada kac tane iframe oldugunu bulabilirsin.
    //switchTo() method’u ile iframe’e gecmenin 3 yolu vardir;
    //driver.switchTo().frame(index of the iframe);
    //driver.switchTo().frame("id or name value of the iframe");
    //driver.switchTo().frame(WebElement of the iframe);
    //Iframe’den cikmak icin 2 komut vardir;
    //driver.switchTo().parentFrame();	Bir ust seviyedeki iframe’e cikartir
    //driver.switchTo().defaultContent();  En ustteki iframe’e cikmak icin kullanilir.

    @Test
    public void iframeTest() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim.
        String actualText = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        String expectedText = "black border";
        Assert.assertTrue(actualText.contains(expectedText));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim.
        driver.switchTo().frame(0); //index 0 dan baslar.(Sitede 1 tane iframe var.)
        String actualInnerText = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedInnerText = "Applications lists";
        Assert.assertEquals(expectedInnerText, actualInnerText);

        //Son olarak footer daki ‘Povered By’ yazisinin varligini test edelim.
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        Assert.assertTrue(footerText.contains("Povered By"));
    }

    /*
    How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini nasil buluruz?
    *** Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda locator kullanarak tum iframe leri bulurum.
    *** driver.findElements(By.tagName(“iframe”));
    *** driver.findElements(By.xpath(“//iframe”));
    ————————————
    Explain how you can switch back to a main page? Tekrar ana sayfaya nasil donersin?
    *** 2 farkli yol vardır;
    *** defaultContent() ya da parentFrame() metotlarını kullarak gecis yapabiliriz.
    ———————————-
    What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdir?
    *** Oncelikle her ikiside frame in disina cikmamizi saglar. Ama defaultContent() direk ana sayfaya atlatır, parentFrame() ise bir üst seviyeye atlatir.
    —————————————
    What might be the reason for your test case to fail? Bir test case in fail etme sebepleri neler olabilir?
    1. Yanlis locator. Cozum: Tekrar element i locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
    2. Wait/Synchronization/Bekleme problemi: Cozum: implicit wait de yeterli sure oldugundan emin oluruz. Verilen sureyi arttırabiliriz. Explicit wait kullanilabilir.
    3. Iframe. Cozum: switch to iframe
    4. Alert. Cozum: switch to alert
    5. New window(Yeni pencere): switch to window
    */

}
