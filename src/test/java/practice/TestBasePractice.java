package practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBasePractice {

    //1- <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports --> pom.xml'e yüklemek
    //2- Eğer extentReport almak istersek ilk yapmamız gereken ExtentReports class'ından bir obje oluşturmak
    //3- HTML formatında düzenleneceği için ExtentHtmlReporter class'ından obje oluşturmak

    protected static WebDriver driver;
    protected ExtentReports extentReports; //Raporlamayı başlatırız
    protected ExtentHtmlReporter extentHtmlReporter; //Raporumu HTML formatında düzenler
    protected ExtentTest extentTest; //Test asamalarina extentTest objesi ile bilgi ekleriz

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //----------------------------------------------------------------
        extentReports = new ExtentReports();
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currentTime + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(path);
        extentReports.attachReporter(extentHtmlReporter); //Klasor un icine raporlari kaydeder
        //Raporda gözükmesini istediğimiz bilgiler için, raporu bu sekilde customize edebiliriz
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Tugba");
        extentHtmlReporter.config().setDocumentTitle("Extent Report"); //EXTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBILIRSIN
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");
        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Raporu");
    }

    @After
    public void tearDown() {
        driver.quit();
        extentReports.flush(); //raporu goster
    }

}
