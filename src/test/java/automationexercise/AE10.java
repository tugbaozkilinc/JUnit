package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AE10 extends TestBase {

    @Test
    public void test01() throws AWTException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Scroll down to footer
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);

        //5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());

        //6. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//*[@id='susbscribe_email']")).sendKeys("ab@gmail.com");
        driver.findElement(By.xpath("//*[@class='fa fa-arrow-circle-o-right']")).click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']")).isDisplayed());
    }

}
