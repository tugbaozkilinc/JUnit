package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {

    @Test
    public void dragAndDropTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source, target).perform();
        waitFor(5);
    }

    @Test
    public void clickAndHoldTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
        //build() onceki method larin iliskisini guclendirir, kullanilmasi zorunlu degil fakat tercih edilir.
    }

    @Test
    public void moveByOffSetTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        actions.clickAndHold(source).moveByOffset(430, 30).release().build().perform();
    }

}
