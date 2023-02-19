package day12;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Homework04 extends TestBase {

    @Test
    public void test01() {
        //1. "http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String firstWindowHandle = driver.getWindowHandle();

        //2. "Login Portal" a  kadar asagi inin
        //3. "Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();

        //4. Diger windows'a gecin
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.stream().filter(t -> !t.equals(firstWindowHandle)).forEach(t -> driver.switchTo().window(t));

        //5. "username" ve "password" kutularina deger yazdirin
        //6. "login" butonuna basin
        Faker faker = new Faker();
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys(faker.name().username(), Keys.TAB, faker.internet().password(), Keys.TAB, Keys.ENTER);

        //7. Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertEquals("validation failed", driver.switchTo().alert().getText());

        //8. Ok diyerek Pop up'i kapatin
        driver.switchTo().alert().accept();

        //9. Ilk sayfaya geri donun
        driver.switchTo().window(firstWindowHandle);

        //10. Ilk sayfaya donuldugunu test edin
        Assert.assertEquals("http://webdriveruniversity.com/", driver.getCurrentUrl());
    }

}
