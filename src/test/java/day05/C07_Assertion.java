package day05;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class C07_Assertion {

    //Note: Test icin uygun bir sekilde hazirlanmis bir framework’da expected degerlerin actual degerlere esit olup olmadigina if-else statement ile bakilmaz.
    //ONEMLI OLAN kiyaslama sonucunun true veya false olmasi degil, bekledigimiz sonucun olup olmamasidir. Assertion başarısız olursa AssertionException ile hata mesajı verilir.

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    //https://www.amazon.com adresine gidin
    //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin;
    //Sayfa başlığının “Amazon” oldugunu test edin
    //Amazon resminin görüntülendiğini (isDisplayed()) test edin
    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //Sayfa basliginin “amazon” olmadigini dogrulayin

    @Test
    public void test01() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test02() {
        WebElement element = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        assertTrue(element.isDisplayed()); //Bunu if else ile yapsan ve consolda failed yazisini gorsen bile testin passed olur, Bunun icin if else kullanmiyoruz.
    }

    @Test
    public void test03(){
        WebElement element = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        assertTrue(element.isEnabled());
    }

    @Test
    public void test04() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    //assertTrue(True)  ---> Passed
    //assertTrue(False) ---> Failed
    //assertFalse(False)---> Passed
    //assertFalse(True) ---> Failed

}
