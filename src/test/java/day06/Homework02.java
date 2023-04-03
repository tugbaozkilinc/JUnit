package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Homework02 {

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    //https://www.amazon.com/ adresine gidin.
    //Test 1:
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
    //Test 2:
    //Kategori menusunden Books secenegini secin
    //Arama kutusuna Java yazin ve aratin
    //Bulunan sonuc sayisini yazdirin
    //Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test01() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select searchBoxDropdown = new Select(searchBox);
        List<WebElement> listSearchBoxDropdown = searchBoxDropdown.getOptions();
        int listSize = listSearchBoxDropdown.size();
        Assert.assertEquals(28, listSize);
        searchBoxDropdown.selectByVisibleText("Books");
        Thread.sleep(3000);
        searchBoxDropdown.selectByVisibleText("All Departments");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
        WebElement resultForJava = driver.findElement(By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultForJava.getText());
        String[] arr = resultForJava.getText().split(" ");
        Arrays.stream(arr).limit(4).skip(3).forEach(System.out::println);
        Assert.assertTrue(resultForJava.getText().contains("Java"));
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

}
