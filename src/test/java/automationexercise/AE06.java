package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AE06 extends TestBase {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed());

        //6. Enter name, email, subject and message
        //7. Upload file
        //8. Click 'Submit' button
        //9. Click OK button
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Angela", Keys.TAB, "ac@gmail.com", Keys.TAB, "Angela", Keys.TAB, "Angela");
        WebElement upload_file = driver.findElement(By.name("upload_file"));
        upload_file.sendKeys("C:/Users/tugba/Desktop/03.docx");
        driver.findElement(By.xpath("//input[@class='btn btn-primary pull-left submit_form']")).click();
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//*[@href='/'])[2]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='shop-menu pull-right']")).isDisplayed());
    }

}
