package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {

    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;
    @Test
    public void extentReportsTest() {
        //Extent Reports?
        //<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports --> ilgili dependency yuklenir.
        //Otomasyon raporlari almak icin kullanilir.
        //Extent report bir API dir. Extent reports Selenium un disinda da kullanilabilir. Bu API dan gelen method lar yardimiyla rapor sablonu olusturulabilir.
        //3 class kullaniriz: ExtentReports: sablonu olusturur, ExtentHtmlReporter: sablonu projeye ekler, ExtentTest: raporlama islemini yapar
        //Extent Reports :
        //HTML raporlama aracıdır. Bize Html raporlarını verir. Test adımlarını kaydetmemize yardımcı olur. Ayrıca ekran görüntülerini ekleyebiliriz.
        //3 tane obje olusturup kullaniriz.

        //REPORT PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currentTime + "html_report.html";
        //Creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
        //Creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //***************RAPORU CUSTOMIZE EDEBILIRIZ************************************************
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application", "TechPro Education");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Eagles");
        extentReports.setSystemInfo("Epic", "Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint No", "Sprint145");
        extentReports.setSystemInfo("QA", "Tugba");

        //***************EXTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBILIRSINIZ**************************
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

        //**************RAPOR AYARLARI BİTTİ********************************************************

        //Raporu projeme ekliyorum.
        extentReports.attachReporter(extentHtmlReporter);
        //Extent Test objesini olustur
        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Raporu");
        //TUM AYARLAR BITTI. EXTENT TEST OBJESI ILE LOGLAMA(RAPOR YAZDIRMA) ISLEMINI YAPABILIRIM
        extentTest.info("Kullanici ana sayfaya gider");
        driver.get("https://www.techproeducation.com");
        //LMS SAYFASINA GIDELIM
        extentTest.info("Kullanici LMS sayfasina gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();
        //TEST BITTI
        extentTest.pass("TEST BASARIYLA GERCEKLESTI");
        //RAPORU GOSTER
        extentReports.flush();
    }

}
