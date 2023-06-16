package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Homework02 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //go to url: https://demo.automationtesting.in/Alerts.html
        driver.get("https://demo.automationtesting.in/Alerts.html");

        //click "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//*[@href='#OKTab']")).click();
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

        //accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("//*[.='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        //cancel Alert(Press a Button !)
        driver.switchTo().alert().dismiss();

        //click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

        //and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechproEducation");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        String text = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        Assert.assertTrue(text.contains("TechproEducation"));

        //finally print on console this message "Hello TechproEducation How are you today"
        System.out.println(text);
    }

}
