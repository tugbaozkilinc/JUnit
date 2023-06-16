package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework04 extends TestBase {

    @Test
    public void dragAndDopTest() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(element).perform();
        waitFor(2);

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        //4. Popup mesajini yazdirin
        System.out.println("Pop up message is: " + driver.switchTo().alert().getText());

        //5. Pop up'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButton = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHoldButton).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']")).getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickButton = driver.findElement(By.xpath("//*[@id='double-click']"));
        String previousColor = doubleClickButton.getCssValue("background-color"); //background-color --> bir stil ozelligidir
        actions.doubleClick(doubleClickButton).perform();

        //9. "Double click me" butonunun renk değiştirdiğini doğrulayın
        String recentColor = doubleClickButton.getCssValue("background-color");
        Assert.assertNotEquals(recentColor, previousColor);
    }

}
