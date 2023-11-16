package practice.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class P01 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Dropdown menuyu yazdiralim
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdown.forEach(t -> System.out.println(t.getText()));

        //Dropdown menuden baby secelim.
        //Arama bolumunden milk aratalim.
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB, "Milk", Keys.ENTER);
        Thread.sleep(2000);
    }

}
