package day15;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Homework01 extends TestBase {

    @Test
    public void webTables() {
        //https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

        //tüm E-mail leri yazdırın
        List<WebElement> list = driver.findElements(By.xpath("//table[@rows='rowCollection']//tbody//tr//td[7]"));
        list.forEach(t -> System.out.println(t.getText()));

        //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        int counter = 0;
        for (WebElement webElement : list) {
            if (webElement.getText().contains("@")) {
                counter++;
            }
        }
        Assert.assertEquals(list.size(), counter);
    }

}
