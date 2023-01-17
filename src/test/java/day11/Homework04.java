package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework04 extends TestBase {

    @Test
    public void fakerTest() {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim
        Actions actions = new Actions(driver);
        WebElement createButton = driver.findElement(By.xpath("(//*[@role='button'])[2]"));
        actions.click(createButton).perform();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Faker faker = new Faker();
        WebElement firstNameButton = driver.findElement(By.xpath("//*[@name='firstname']"));
        actions.sendKeys(firstNameButton, faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, "ab@gmail.com", Keys.TAB, "ab@gmail.com", Keys.TAB,
                        faker.internet().password(), Keys.TAB, Keys.TAB, "10", Keys.TAB, "March", Keys.TAB, "1990", Keys.TAB, Keys.TAB, Keys.SPACE).perform();
        WebElement signUpButton = driver.findElement(By.xpath("(//*[@type='submit'])[2]"));
        actions.click(signUpButton).perform();
    }

}
