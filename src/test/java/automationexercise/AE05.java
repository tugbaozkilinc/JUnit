package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AE05 extends TestBase {

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

        //5. Verify 'New User Signup!' is visible
        WebElement signupElement = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(signupElement.isDisplayed());

        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Angela", Keys.TAB, "angela02@gmail.com", Keys.TAB, Keys.ENTER);

        //8. Verify error 'Email Address already exist!' is visible
        WebElement text = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        Assert.assertTrue(text.isDisplayed());
    }

}
