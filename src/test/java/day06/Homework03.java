package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Homework03 {

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }

    // http://zero.webappsecurity.com/ Adresine gidin
    // Sign in butonuna basin
    // Login kutusuna “username” yazin
    // Password kutusuna “password.” yazin
    // Sign in tusuna basin
    // Pay Bills sayfasina gidin
    // “Purchase Foreign Currency” tusuna basin
    // “Currency” drop down menusunden Eurozone’u secin
    // “amount” kutusuna bir sayi girin
    // “US Dollars” in secilmedigini test edin
    // “Selected currency” butonunu secin
    // “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    // “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.


    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username");
        driver.findElement(By.cssSelector("input[id='user_password']")).sendKeys("password");
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();
        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select currencyDropdown = new Select(currency);
        currencyDropdown.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("5");
        driver.findElement(By.cssSelector("input[id='pc_inDollars_true']")).click();
        driver.findElement(By.cssSelector("input[id='pc_calculate_costs']")).click();
        driver.findElement(By.id("purchase_cash")).click();
        String actualStatement = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']")).getText();
        String expectedStatement = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(actualStatement, expectedStatement);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
