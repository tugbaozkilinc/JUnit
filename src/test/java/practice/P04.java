package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement element = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i<100; i++){
            element.click();
        }

        // 100 defa basıldığını test ediniz
        List<WebElement> deleteButton = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(100, deleteButton.size());

        // 90 defa delete butonuna basınız
        for (int i = 0; i<90; i++){
            driver.findElement(By.cssSelector("button[onclick='deleteElement()']")).click();
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement> deleteElementList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int deleteElement = deleteButton.size()-90;
        Assert.assertEquals(deleteElement, deleteElementList.size());

        // Sayfayı kapatınız
        driver.close();

    }
}
