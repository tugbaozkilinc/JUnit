package practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBasePractice {

    //Abstract yapmamızın sebebi; bu sınıftan doğrudan nesneler oluşturulmasının istenmemesidir. Eğer TestBase sınıfından nesneler oluşturulabilirse, bu sınıf yanlışlıkla test sınıfı olarak
    //kullanılabilir veya yanlış bir şekilde kullanılabilir.

    protected WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        extentReports = new ExtentReports();
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currentTime + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(path);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Tugba");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Regression Test Result");
        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Report");
    }

    @After
    public void tearDown() {
        driver.quit();
        extentReports.flush();
    }

}
