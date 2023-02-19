package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework04 {

    //Given kullanici "https://editor.datatables.net/" sayfasina gider
    //Then new butonuna basar
    //And editor firstname kutusuna "<firstName>" bilgileri girer
    //And editor lastname kutusuna "<lastName>" bilgileri girer
    //And editor position kutusuna "<position>" bilgileri girer
    //And editor office kutusuna "<office>" bilgileri girer
    //And editor extension kutusuna "<extension>" bilgileri girer
    //And editor startdate kutusuna "<startDate>" bilgileri girer
    //And editor salary kutusuna "<salary>" bilgileri girer
    //When Create tusuna basar

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://editor.datatables.net/");
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();
        driver.findElement(By.xpath("//input[@id='DTE_Field_first_name']")).sendKeys("Ayca", Keys.TAB, "Can", Keys.TAB, "position", Keys.TAB, "office",
        Keys.TAB, "abac", Keys.TAB, "2022-12-13", Keys.TAB, "56", Keys.ENTER);
    }

    @Test
    public void test01() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Ayca Can']")).isDisplayed());
    }

    @Test
    public void test02() {
        driver.findElement(By.xpath("//*[@id='row_58']")).click();
        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();
        driver.findElement(By.xpath("//*[@class='btn']")).click();
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Ayca Can");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='No matching records found']")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
