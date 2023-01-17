package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AE07 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
        driver.navigate().refresh();

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();

        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Test Cases']")).isDisplayed());
    }

}
