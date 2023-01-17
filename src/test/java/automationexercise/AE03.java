package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AE03 extends TestBase {

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

        //6. Enter incorrect email address and password
        //7. Click 'login' button
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ab@gmail.com", Keys.TAB, "12345", Keys.TAB, Keys.ENTER);

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement firstText = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(firstText.isDisplayed());
    }

}
