package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AE11 extends TestBase {

    @Test
    public void test01() throws AWTException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //5. Scroll down to footer
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);

        //6. Verify text 'SUBSCRIPTION'
        String text = driver.findElement(By.xpath("//*[text()='Subscription']")).getText();
        Assert.assertEquals("SUBSCRIPTION", text);

        //7. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//*[@id='susbscribe_email']")).sendKeys("ab@gmail.com");
        driver.findElement(By.xpath("//*[@class='fa fa-arrow-circle-o-right']")).click();

        //8. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']")).isDisplayed());
    }

}
