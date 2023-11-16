package practice.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P03 extends TestBase {

    @Test
    public void name() {
        //https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //ikinci emojiye tıklayın
        int iframeNumber = driver.findElements(By.xpath("//*[@id='emoojis']")).size();
        System.out.println(iframeNumber);
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe); //driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        //tüm ikinci emoji öğelerini tıklayın
        List<WebElement> animals = driver.findElements(By.xpath("//*[@id='nature']//div/img")); // //*[@id='nature']//img   //*[@id='nature']//div//img
        animals.forEach(WebElement::click);

        //parent iframe e geri donun
        driver.switchTo().defaultContent();
        //driver.navigate().refresh(); --> digeri aklina gelmezse bu bir secenek fakat daha once tikladiklarin kaybolur sayfa ilk haline doner.

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> formList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> inputs = new ArrayList<>(Arrays.asList("Sea", "Sea", "Sea", "Sea", "Sea", "Sea", "Sea", "Sea", "Sea", "Sea", "Sea", "Sea", "Sea"));
        for(int i = 0; i< formList.size(); i++){
            formList.get(i).sendKeys(inputs.get(i));
        }

        //apply button a basin
        driver.findElement(By.xpath("//*[text()='Apply']")).click();
    }

}
