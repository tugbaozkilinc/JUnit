package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class AE08 extends TestBase {

    @Test
    public void test01() throws AWTException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

        //7. Click on 'View Product' of first product
        Robot robot = new Robot();
        robot.mouseWheel(8);
        driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();

        //8. User is landed to product detail page
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product-information']")).isDisplayed());

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Blue Top']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Category: Women > Tops']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Rs. 500']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Availability:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Condition:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Brand:']")).isDisplayed());
    }

}
