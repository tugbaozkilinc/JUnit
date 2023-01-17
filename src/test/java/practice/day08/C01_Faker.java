package practice.day08;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01() {
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        // isim kutusunu locate ediniz
        WebElement element = driver.findElement(By.xpath("//input[@name='firstname']"));

        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        actions.click(element).sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, "angela@gmail.com", Keys.TAB, "angela@gmail.com",
                      Keys.TAB, faker.internet().password(), Keys.TAB, Keys.TAB, "13", Keys.TAB, "February", Keys.TAB, "2000", Keys.TAB, Keys.TAB, Keys.SPACE,
                      Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).perform();
    }

}
