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
import java.util.List;

public class Homework01 {

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True, degilse False yazdırın.

    @Test
    public void clickOptions() throws InterruptedException {
        WebElement option1 = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option1Dropdown = new Select(option1);
        option1Dropdown.selectByIndex(1);
        option1Dropdown.selectByVisibleText("Option 1");
        System.out.println(option1Dropdown.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        WebElement option2 = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option2Dropdown = new Select(option2);
        option2Dropdown.selectByValue("2");
        System.out.println(option2Dropdown.getFirstSelectedOption().getText());
    }

    @Test
    public void printOptions() {
        WebElement options = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select optionsDropdown = new Select(options);
        List<WebElement> optionsList = optionsDropdown.getOptions();
        optionsList.forEach(t -> System.out.println(t.getText()));
        int dropdownSize = optionsList.size();
        Assert.assertEquals(3, dropdownSize);
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

}
