package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AE01 extends TestBase {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement shopMenuElement = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']"));
        Assert.assertTrue(shopMenuElement.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement signupElement = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(signupElement.isDisplayed());

        //6. Enter name and email address
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Angela", Keys.TAB, "angela3@gmail.com", Keys.TAB, Keys.ENTER);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement textElement = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(textElement.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//input[@id='id_gender2']")).sendKeys(Keys.SPACE, Keys.TAB, "Angela", Keys.TAB, "1234", Keys.TAB, "1", Keys.TAB,
                "January", Keys.TAB, "2000", Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea",
                Keys.TAB, "United States", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, "Sea", Keys.TAB, Keys.ENTER);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement firstText = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(firstText.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //16. Verify that 'Logged in as username' is visible
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement secondText = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(secondText.isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    }

}
