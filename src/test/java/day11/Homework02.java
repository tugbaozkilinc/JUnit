package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework02 extends TestBase {

    @Test
    public void keyboardActionsTest() {
        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(iframe);

        // videoyu izlemek icin Play tusuna basin
        WebElement playButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        actions.click(playButton).perform();

        // videoyu calistirdiginizi test edin
        Assert.assertTrue(playButton.isEnabled());
    }

}
