package practice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P02 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //go to url: http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //click "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

        //accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("//*[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        //cancel Alert (Press a Button !)
        driver.switchTo().alert().dismiss();

        //click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

        //and then sendKeys 'TechproEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechproEducation");
        driver.switchTo().alert().accept();

        //finally print on console this message "Hello TechProEducation How are you today"
        String actualText = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println(actualText);

        //Assert these message
        String expectedText = "Hello TechProEducation How are you today";
        Assert.assertNotEquals(expectedText, actualText);
    }

}
