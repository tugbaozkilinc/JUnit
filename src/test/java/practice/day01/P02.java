package practice.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class P02 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        //fill the firstname
        //fill the lastname
        //check the gender
        //check the experience
        //fill the date
        //choose your profession -> Automation Tester
        //choose your tool -> Selenium Webdriver
        //choose your continent -> Antartica
        //choose your command  -> Browser Commands
        //click submit button
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Ayca", Keys.TAB, "Can", Keys.TAB, Keys.ARROW_RIGHT, Keys.TAB,
                Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.TAB, "12/12/2022", Keys.TAB, Keys.TAB, Keys.SPACE, Keys.TAB, Keys.TAB,Keys.TAB,
                Keys.SPACE, Keys.TAB, "Africa", Keys.TAB, Keys.LEFT_CONTROL, Keys.SPACE, Keys.ARROW_DOWN, Keys.SPACE, Keys.ARROW_DOWN, Keys.SPACE, Keys.TAB,
                Keys.TAB, Keys.TAB, Keys.ENTER);
        driver.close();
    }

}
