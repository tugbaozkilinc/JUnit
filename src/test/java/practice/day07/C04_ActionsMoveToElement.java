package practice.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import java.util.ArrayList;
import java.util.List;

public class C04_ActionsMoveToElement extends TestBase {

    @Test
    public void test01() {
        //https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");

        //sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(//*[@class='nav-line-2'])[1]"));
        actions.moveToElement(element).perform();
        waitFor(2);

        //Change country/region butonuna basiniz
        driver.findElement(By.xpath("//*[text()='Change country/region.']")).click();

        //United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement box = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select dropdownBox = new Select(box);
        dropdownBox.selectByVisibleText("Turkey (Türkiye)");
        driver.findElement(By.xpath("//*[text()='Changing country/region website']")).click();
        //Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();

        //acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));
    }

}
