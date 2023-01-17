package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class AE14 extends TestBase {

    @Test
    public void test01() throws AWTException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Add products to cart
        Robot robot = new Robot();
        robot.mouseWheel(8);
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();

        //5. Click 'View Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='active']")).isDisplayed());

        //7. Click Proceed To Checkout
        driver.findElement(By.linkText("Proceed To Checkout")).click();

        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();

        //9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Angela", Keys.TAB, "angela10@gmail.com", Keys.TAB, Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='id_gender2']")).sendKeys(Keys.SPACE, Keys.TAB, "Angela", Keys.TAB, "1234", Keys.TAB, "1", Keys.TAB,
                "January", Keys.TAB, "2000", Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea",
                Keys.TAB, "United States", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, Keys.ENTER);

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement firstText = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(firstText.isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //11. Verify ' Logged in as username' at top
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed());

        //12. Click 'Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //14. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='heading'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='heading'])[2]")).isDisplayed());

        //15. Enter description in comment text area and click 'Place Order'
        robot.mouseWheel(8);
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Angela", Keys.TAB, Keys.ENTER);

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//*[@name='name_on_card']")).sendKeys("Sea", Keys.TAB, "1234", Keys.TAB, "311", Keys.TAB, "12", Keys.TAB, "2000",
                           Keys.TAB, Keys.ENTER);

        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).isDisplayed());

        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
    }

}
