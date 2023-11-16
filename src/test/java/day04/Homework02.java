package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Homework02 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");
        Thread.sleep(2000);

        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        //4. Login tusuna basin
        driver.findElement(By.cssSelector("input[id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement element =  driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String productName = element.getText();
        element.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String productBought = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
        String result = productBought.equals(productName) ? "The process of buying PASSED" : "The process of buying FAILED";
        System.out.println(result);

        //9. Sayfayi kapatin
        driver.close();
    }

}
