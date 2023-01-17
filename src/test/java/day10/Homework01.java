package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework01 extends TestBase {

    @Test
    public void dragAndDropTest() {
        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.dragAndDrop(source, target).perform();
        waitFor(2);

        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }

    @Test
    public void clickAndHoldTest() {
        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
        waitFor(2);

        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }

}
