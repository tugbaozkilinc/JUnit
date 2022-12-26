package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropdownReusable {

    WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    // Reusable method olusturalim.
    public static void selectFromDropdown(WebElement dropdown, String choice){
        // selectFromDropdown(driver.findElement(By.xpath("//*[@id='year']")), "2005");
        // selectFromDropdown(driver.findElement(By.xpath("//*[@id='month']")), "January");
        // selectFromDropdown(driver.findElement(By.id("day")), "12");
        List<WebElement> options = dropdown.findElements(By.tagName("option")); // Gonderilen dropdown elementinin tum options lari alinir.
        for(WebElement w : options){
            if(w.getText().equals(choice)){
                w.click();
                break;
            }
        }
    }

}
