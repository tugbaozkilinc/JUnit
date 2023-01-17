package practice.day06;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions extends TestBase {

    @Test
    public void test01() {
        // http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        // Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='div2']"));
        String before = element.getCssValue("background-color");
        actions.moveToElement(element).perform();
        waitFor(3);
        String after = element.getCssValue("background-color");
        Assert.assertNotEquals(after, before);

        // Double Clicked! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        actions.doubleClick(driver.findElement(By.xpath("//*[text()='Double Click Me !']"))).perform();
        Assert.assertEquals("Double Clicked !!", driver.switchTo().alert().getText());

        // Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

        // Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef kutuda "Dropped!" yazildigini dogrulayin
        WebElement source = driver.findElement(By.xpath("//*[text()='Drag me to my target']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(source, target).perform();
        Assert.assertEquals("Dropped!", target.getText());
    }

}
