package practice.day09;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void fakerTest() {
        //"https://demoqa.com/automation-practice-form" Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");

        //Formu doldurunuz
        WebElement element = driver.findElement(By.xpath("//input[@id='firstName']"));
        Faker faker = new Faker();
        element.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, faker.internet().emailAddress(), Keys.TAB, Keys.ARROW_RIGHT, Keys.SPACE, Keys.TAB,
                faker.number().digits(10), Keys.TAB, "15 January 2022", Keys.ENTER, Keys.TAB, faker.shakespeare().romeoAndJulietQuote(), Keys.TAB, Keys.TAB, Keys.TAB, Keys.SPACE);
        WebElement upload = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        upload.sendKeys("C:\\Users\\tugba\\Desktop\\image.png");
        driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys(faker.address().fullAddress(), Keys.TAB, "NCR", Keys.ENTER, Keys.TAB,
                "Delhi", Keys.TAB, Keys.ENTER);

        //Sayfayi kapatiniz
        waitFor(2);
        driver.findElement(By.xpath("//*[@id='closeLargeModal']")).click();
    }

}