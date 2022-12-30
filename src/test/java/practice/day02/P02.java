package practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P02 {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        WebElement baby = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select babyDropdown = new Select(baby);
        babyDropdown.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        System.out.println(babyDropdown.getFirstSelectedOption().getText());

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> webElementList = babyDropdown.getOptions();
        Assert.assertEquals(28, webElementList.size());
    }

}
