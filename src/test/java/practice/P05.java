package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // BeforeClass ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    // http://www.google.com adresine gidin
    // arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    // arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    // arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    // AfterClass ile kapatın

    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com ");
    }

    @Test
    public void test01() {
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("The God Father", Keys.ENTER);
    }

    @Test
    public void test02() {
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Lord of the Rings", Keys.ENTER);
    }

    @Test
    public void test03() {
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Kill Bill", Keys.ENTER);
    }

    @After
    public void tearDown() throws Exception {
        String[] arr = driver.findElement(By.cssSelector("div[id='result-stats']")).getText().split(" ");
        System.out.println(arr[1]);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
