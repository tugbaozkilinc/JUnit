package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework02 extends TestBase {

    @Test
    public void moveToElementTest() {
        // https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        // Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        actions.moveToElement(element).perform();
        waitFor(2);

        // “Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        // Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        Assert.assertEquals("Your Lists", driver.findElement(By.xpath("//*[@role='heading']")).getText());
    }

}
