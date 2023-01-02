package day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Homework09 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        int iframeNumber = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Iframe number is: " + iframeNumber);
        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> emojis = driver.findElements(By.xpath("//*[@id='nature']//div//img"));
        emojis.forEach(WebElement::click);

        // Ana iframe'e geri dön
        driver.switchTo().defaultContent();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        // uygula butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Emojis", Keys.TAB, "Happy", Keys.TAB, "Animal", Keys.TAB, "Fish", Keys.TAB, "Swim",
                                                                               Keys.TAB, "Miami", Keys.TAB, "Mirror", Keys.TAB, "Square", Keys.TAB, "Turkey", Keys.TAB, Keys.TAB,
                                                                               Keys.TAB, Keys.ENTER);
        Thread.sleep(2000);
    }

}
