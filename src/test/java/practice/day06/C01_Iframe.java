package practice.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_Iframe extends TestBase {

    @Test
    public void name() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]")));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();

        // Videoyu calistirdiginizi test ediniz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-sessionlink='feature=player-button']")));
        Assert.assertTrue(element.isDisplayed());

        // 'Powerful, but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Powerful, but easy to misuse']")).isDisplayed());
    }

}
