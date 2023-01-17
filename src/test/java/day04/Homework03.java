package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homework03 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        List<String> list = new ArrayList<>();
        List<String> listDisplayed = new ArrayList<>();

        // Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        // click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();
        Thread.sleep(2000);

        // get the brandName of phones
        String firstOne = driver.findElement(By.xpath("//*[text()='HTC Touch HD']")).getText();
        String secondOne = driver.findElement(By.xpath("//*[text()='iPhone']")).getText();
        String thirdOne = driver.findElement(By.xpath("//*[text()='Palm Treo Pro']")).getText();
        list.add(firstOne);
        list.add(secondOne);
        list.add(thirdOne);

        // click on add to button for all elements
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[3]")).click();
        Thread.sleep(2000);

        // click on black total added cart button
        driver.findElement(By.xpath("//*[@id='cart-total']")).click();

        // get the names of list from the cart
        String firstOneDisplayed = driver.findElement(By.xpath("(//*[text()='HTC Touch HD'])[1]")).getText();
        String secondOneDisplayed = driver.findElement(By.xpath("(//*[text()='iPhone'])[1]")).getText();
        String thirdOneDisplayed = driver.findElement(By.xpath("(//*[text()='Palm Treo Pro'])[1]")).getText();
        listDisplayed.add(firstOneDisplayed);
        listDisplayed.add(secondOneDisplayed);
        listDisplayed.add(thirdOneDisplayed);

        // compare the names from displaying list and cart list
        String result = list.equals(listDisplayed) ? "That the names from displaying list and cart list are equals PASSED" :
                        "That the names from displaying list and cart list are equals FAILED";
        System.out.println(result);

        driver.close();

    }
}
