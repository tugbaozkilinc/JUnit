package practice.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework02 extends TestBase {

    @Test
    public void test01() {
        //https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        WebElement greenKey = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement blueKey = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(greenKey,-175,0); //Genellikle slider' lar için bu method kullanılır
        actions.dragAndDropBy(blueKey,-80,0);
        actions.dragAndDropBy(greenKey,301,0).release().build().perform();

        //Sarı olduğunu test edelim
        WebElement yellow = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        assert yellow.isDisplayed();
    }

}
