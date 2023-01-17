package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AE04 extends TestBase {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement textElement = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(textElement.isDisplayed());

        //6. Enter correct email address and password
        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("angela02@gmail.com", Keys.TAB, "1234", Keys.TAB, Keys.ENTER);

        //8. Verify that 'Logged in as username' is visible
        WebElement firstText = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(firstText.isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//*[@href='/logout']")).click();

        //10. Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/login']")).isDisplayed());
    }

}
