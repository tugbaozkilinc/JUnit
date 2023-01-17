package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class AE16 extends TestBase {

    @Test
    public void test01() throws AWTException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Angela", Keys.TAB, "angela16@gmail.com", Keys.TAB, Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='id_gender2']")).sendKeys(Keys.SPACE, Keys.TAB, "Angela", Keys.TAB, "1234", Keys.TAB, "1", Keys.TAB,
                "January", Keys.TAB, "2000", Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea",
                Keys.TAB, "United States", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, Keys.ENTER);

        //6. Verify 'Logged in as username' at top
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed());

        //7. Add products to cart
        Robot robot = new Robot();
        robot.mouseWheel(8);
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();

        //8. Click 'Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        //9. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='active']")).isDisplayed());

        //10. Click Proceed To Checkout
        driver.findElement(By.linkText("Proceed To Checkout")).click();

        //11. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='heading'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='heading'])[2]")).isDisplayed());

        //12. Enter description in comment text area and click 'Place Order'
        robot.mouseWheel(8);
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Angela", Keys.TAB, Keys.ENTER);

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //14. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//*[@name='name_on_card']")).sendKeys("Sea", Keys.TAB, "1234", Keys.TAB, "311", Keys.TAB, "12", Keys.TAB, "2000",
                Keys.TAB, Keys.ENTER);

        //15. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).isDisplayed());

        //16. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
    }

}
