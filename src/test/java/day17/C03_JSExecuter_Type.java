package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {

    @Test
    public void typeTest() {
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");

        //Arama kutusuna QA yaz
        WebElement searchbox = driver.findElement(By.id("searchHeaderInput"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', 'QA');", searchbox); //Sadece tag i input olanlar icin gecerli.
        //js.executeScript("arguments[0].value='QA'", searchBox);
    }

}
