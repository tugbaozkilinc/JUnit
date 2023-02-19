package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    @Test
    public void windowHandleTest() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstWindowHandle = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", actualText);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet", actualTitle);

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[@href='/windows/new']")).click();
        waitFor(3);

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        switchToWindow(1);
        String titleOfSecondWindow = driver.getTitle();
        Assert.assertEquals("New Window", titleOfSecondWindow);
    }

}
