package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReports2 extends TestBase {

    static ExtentReports extentReports;
    static ExtentHtmlReporter extentHtmlReporter;
    static ExtentTest extentTest;
    @BeforeClass
    public static void beforeClass() {
        //REPORT PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currentTime + "html_report.html";
        //Creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
        //Creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //***************RAPORU CUSTOMIZE EDEBILIRIZ***********************************************
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application", "TechPro Education");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Eagles");
        extentReports.setSystemInfo("Epic", "Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint No", "Sprint145");
        extentReports.setSystemInfo("QA", "Tugba");

        //***************EXTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBILIRSINIZ**************************
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Result");

        //***************RAPOR AYARLARI BİTTİ*******************************************************

        //Raporu projeme ekliyorum.
        extentReports.attachReporter(extentHtmlReporter);
        // Extent Test objesini olustur
        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Report");
    }

    @Test
    public void extentReportsTest() {
        extentTest.pass("PASS");
        extentTest.info("BILGILENDIRME RAPORU");
        extentTest.fail("FAILED");
        extentTest.warning("UYARI MESAJI");
        extentTest.skip("ATLAMA MESAJI");
        extentTest.fatal("COKUS HATASI");
    }

    @AfterClass
    public static void afterClass() {
        extentReports.flush();
    }

    //Raporlamalari nasıl yaparsın?
    //Manual testing yaparken manually ekran goruntusu alip work documanina eklerim. Sonra bu raporları JIRA ya user story e yüklerim
    //Otomasyonda ise Extent Reports ile html raporlarını cikartirim.
    //Extent Reports raporlari değiştirilebilir, özel proje bilgiler eklenebilir raporlardır.
    //Projemde ki raporlama sistemini, test case fail ettiginde otomatik olarak ekran goruntusunu alacak sekilde ayarladim
    //Extent Reports kullanmanın avantajları nelerdir? Neden Extent Reports i tercih ettiniz?
    //Open source- Ücretsiz
    //Farkli browserlar yada isletim sistemleriyle calisabilir
    //Junit, testng, cucumber gibi farklı test otomasyon frameworkleriyle entegre olabilir
    //Her bir test adimini log(rapora yazdirma) yapabiliriz
    //Customizable-Editlenebilir
    //Extent reports ile raporlama islemi nasil gerceklesir? Bilgi verirmisiniz?
    //Oncelikle maven projeleri icin Extent reports dependency oluşturmamız gerekmektedir
    //Reusable classimda extent reports ile alakalı reusable metotlarım var. Bu metotlar yardımıyla raporlarım oluşuyor.
    //3 onemli class vardır:
    //ExtentReports
    //ExtentHtmlReporter.  ====>>>>>>> are user for generation the reports
    //ExtentTest
    //Bu sınıflar yardımıyla, platform, browser, environment, tester, takim bilgileri gibi özel proje bilgileri ekleyebilirim. Ayrıca extent test objesi kullanarak pass, fail, skip gibi loglamalar yapabilirim.
    //Dependency lerini nerden alıyorsun?
    //Şirkette internal bir repository miz var. Bu repodan ihtiyacım olacak dependencyi alıp kullanırım.
    //Dependency sirket reposunda yoksa ne yapılır?
    //Istedigim dependency icin istekde bulunuyorum. Managerlerin onayından sonra eklenen dependencyleri kullanıyorum.

}
