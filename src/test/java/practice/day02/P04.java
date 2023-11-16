package practice.day02;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class P04 {

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //cookies uyarisini kabul ederek kapatin
        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Google"));

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        String[] result = driver.findElement(By.cssSelector("div[id='result-stats']")).getText().split(" ");
        System.out.println("Result is: " + result[1]);

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String newResult = result[1].replaceAll("\\.", "");
        int actualResult = Integer.parseInt(newResult);
        Assert.assertTrue(actualResult>10000000);
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

}
