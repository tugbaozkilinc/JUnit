package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    // TestBase, testlerden önce ve sonra tekrar tekrar kullandığımız kodları içermektedir. İçerisindeki metodları kullanabilmemiz icin extends yapıyoruz.
    // Bu sayede test class’ımızda sadece test case’ler bulunmaktadır.

    /*
      UTILITIES
      -Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra
      - Utilities paketinde Test case'ler yazilmaz.
      - Sadece tekrar kullanilabilecek destek siniflari(Support Class) olusturulur.
      - Bu support class'lar test case'lerin yazilmasini hizlandirir.
    */

    @Test
    public void test01() {
        // techproeducation ana sayfasina gidip, title in Bootcamps kelimesini icerdigini test edelim.
        driver.get("https://techproeducation.com");
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));
    }

}
