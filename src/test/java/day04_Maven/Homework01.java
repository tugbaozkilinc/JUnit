package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 2- cookies uyarisini kabul ederek kapatin
        // 3- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        if(actualTitle.contains("Google")){
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
        }

        // 4- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        // 5- Bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='result-stats']")).getText());

        // 6- Sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] resultNumber = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String actualResult = resultNumber[1];
        actualResult = actualResult.replaceAll("\\.", "");
        long intActualResult = Integer.parseInt(actualResult);
        System.out.println(intActualResult > 10000000 ? "Result number test PASSED" : "Result number test FAILED");

        // 7- Sayfayi kapatin
        driver.close();

    }
}
