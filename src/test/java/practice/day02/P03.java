package practice.day02;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class P03 {

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");

        //electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //Her sayfanın sayfa başlığını yazdıralım
        for (int i = 0; i<24; i++){
            List<WebElement> products = driver.findElements(By.xpath("//*[@width='225' and @height='225']")); //Dongunun dısında olunca web elementini bulamiyor.
            products.get(i).click();
            System.out.println((i+1) + ". title: " + driver.getTitle());
            driver.navigate().back();
        }
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

}
