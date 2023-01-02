package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Homework03 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // 2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement option = driver.findElement(By.cssSelector("select[id='dropdown-class-example']"));
        Select optionDropdown = new Select(option);
        Assert.assertTrue(option.isDisplayed());

        // 3-Option3 ü seçin.
        optionDropdown.selectByVisibleText("Option3");
        Thread.sleep(3000);

        // 4-Option3 ün seçili olduğunu doğrulayın.
        Assert.assertEquals("Option3", optionDropdown.getFirstSelectedOption().getText());
    }

}
