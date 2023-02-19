package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {

    @Test
    public void hoverOverTest() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='nav-link-accountList']")); //Buyuk div i al.
        waitFor(1);
        actions.moveToElement(element).perform();
        waitFor(3);

        //“Account” secenegine tikla
        driver.findElement(By.xpath("//span[text()='Account']")).click();

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }

}
