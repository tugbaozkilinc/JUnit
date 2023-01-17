package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class AE12 extends TestBase {

    @Test
    public void test01() throws AWTException, InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Hover over first product and click 'Add to cart'
        Robot robot = new Robot();
        robot.mouseWheel(8);
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        Thread.sleep(2000);

        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[@data-product-id='2'])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[@href='/product_details/2']")).click();

        //9. Verify both products are added to Cart
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='product-1']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='product-2']")).isDisplayed());

        //10. Verify their prices, quantity and total price
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Rs. 500'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Rs. 400'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Rs. 500'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Rs. 400'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='disabled'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='disabled'])[2]")).isDisplayed());
    }

}
