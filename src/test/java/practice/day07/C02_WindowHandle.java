package practice.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import java.util.Set;

public class C02_WindowHandle extends TestBase {

    @Test
    public void test01() {
        //1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String firstWindowHandle = driver.getWindowHandle();

        //2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        //4- title'in 'Best Buy' icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        //5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(firstWindowHandle);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);

        //6- arama sonuclarının 'java' icerdigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("java"));

        //7- ikinci sayfaya(bestbuy) donelim
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.stream().filter(t -> !t.equals(firstWindowHandle)).forEach(t -> driver.switchTo().window(t));

        //8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]")).isDisplayed());
    }

}
