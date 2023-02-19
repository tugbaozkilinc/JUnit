package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    @Test
    public void rightClickTest() {
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(element).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", text);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        switchToWindow(1);
        Assert.assertEquals("Elemental Selenium", driver.findElement(By.xpath("//h1")).getText());
    }

}
