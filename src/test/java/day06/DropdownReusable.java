package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class DropdownReusable {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    public void selectFromDropdown(WebElement dropdown, String choice){
        //Gonderilen dropdown element in tum options lari alinir.
        List<WebElement> options = dropdown.findElements(By.tagName("option")); //Tum option tag li elementleri aliyorum
        for (WebElement w : options){
            if (w.getText().equals(choice)){
                w.click();
                break;
            }
        }
    }

    @Test
    public void selectFromDropdown() throws InterruptedException {
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005");
        Thread.sleep(2000);
        selectFromDropdown(driver.findElement(By.id("month")),"November");
        Thread.sleep(2000);
        selectFromDropdown(driver.findElement(By.id("day")),"10");
        Thread.sleep(2000);
        selectFromDropdown(driver.findElement(By.id("state")),"Texas");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElement(By.id("state")).findElements(By.tagName("option")); //state id'sine sahip olan dropdown'in tum option tag'ine sahip olan elementlerini aldik.
                                                                                                          //Sectigimiz webElement'in icindeki baska webElement'leri bu sekilde alabiliyoruz.
        for (WebElement w : options){
            System.out.println(w.getText());
        }
        driver.close();
    }

    //Dropdown?
    //-Acilir menu. Birden fazla seçenegi koyabilecegimiz liste.
    //***Dropdown nasil automate edilir? How to handle dropdown?
    //Dropdown elementi locate edilir. 8 locator dan biri kulllanilabilir.
    //Select class i kullanilarak bir Select objesi olusturulur. Select select = new Select(dropdownElement);
    //Select object ini kullanarak uygun methodlarla islem yapilir.
    //selectBylndex(int);
    //selectByValue(“String”);
    //selectByVisibleText(“String”);
    //getOptions(); tum dropdown seçeneklerini List<WebElement> olarak return eder.
    //getFirstSelectedOption(); secili olan ilk secenegi(default) return eder.

}
