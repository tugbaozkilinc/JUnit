package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class AE13 extends TestBase {

    @Test
    public void test01() throws AWTException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click 'View Product' for any product on home page
        Robot robot = new Robot();
        robot.mouseWheel(7);
        waitFor(2);
        driver.findElement(By.xpath("//a[@href='/product_details/2']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/product_details/2']")).click();

        //5. Verify product detail is opened
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product-information']")).isDisplayed());

        //6. Increase quantity to 4
        WebElement element = driver.findElement(By.xpath("//*[@id='quantity']"));
        element.clear();
        element.sendKeys("4");

        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //9. Verify that product is displayed in cart page with exact quantity
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='disabled']")).isDisplayed());
    }

}
