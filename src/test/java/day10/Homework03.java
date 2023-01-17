package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework03 extends TestBase {

    @Test
    public void dragAndDropTest() {
        // go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // #Fill in capitals by country
        Actions actions = new Actions(driver);
        WebElement washington = driver.findElement(By.xpath("(//*[text()='Washington'])[2]"));
        WebElement unitedStates = driver.findElement(By.xpath("//*[text()='United States']"));
        actions.dragAndDrop(washington, unitedStates).perform();
        WebElement rome = driver.findElement(By.xpath("(//*[text()='Rome'])[2]"));
        WebElement italy = driver.findElement(By.xpath("//*[text()='Italy']"));
        actions.dragAndDrop(rome, italy).perform();
        WebElement madrid = driver.findElement(By.xpath("(//*[text()='Madrid'])[2]"));
        WebElement spain = driver.findElement(By.xpath("//*[text()='Spain']"));
        actions.dragAndDrop(madrid, spain).perform();
        WebElement oslo = driver.findElement(By.xpath("(//*[text()='Oslo'])[2]"));
        WebElement norway = driver.findElement(By.xpath("//*[text()='Norway']"));
        actions.dragAndDrop(oslo, norway).perform();
        WebElement copenhagen = driver.findElement(By.xpath("(//*[text()='Copenhagen'])[2]"));
        WebElement denmark = driver.findElement(By.xpath("//*[text()='Denmark']"));
        actions.dragAndDrop(copenhagen, denmark).perform();
        WebElement seoul = driver.findElement(By.xpath("(//*[text()='Seoul'])[2]"));
        WebElement southKorea = driver.findElement(By.xpath("//*[text()='South Korea']"));
        actions.dragAndDrop(seoul, southKorea).perform();
        WebElement stockholm = driver.findElement(By.xpath("(//*[text()='Stockholm'])[2]"));
        WebElement sweden = driver.findElement(By.xpath("//*[text()='Sweden']"));
        actions.dragAndDrop(stockholm, sweden).perform();
    }

}
