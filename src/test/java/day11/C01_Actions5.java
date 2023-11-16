package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {

    @Test
    public void keyboardActionsTest() {
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK ‘cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK) Ve ENTER tusuna bas
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.name("q"));
        actions.keyDown(searchBox, Keys.SHIFT). //arama kutusunun ustundeyken shift e bas
                sendKeys("iPhone X fiyatlari"). //shift e basiliyken yazi yaz
                keyUp(searchBox, Keys.SHIFT). //shift e basmayi birak
                sendKeys(" cok pahali!", Keys.ENTER).build().perform();
    }

    //1- Actions nedir?
    //Actions selenium dan gelen bir kütüphanedir. Mouse ve Keyboard işlemlerini gerçekleştirmek icin kullandigimiz hazır bir selenium kütüphanesidir.
    //Ornegin, sag tiklamak(contextClick()), çift tıklamak(doubleClick()), elementin uzerine gitmek(moveToElement()) gibi mouse işlemlerini gerçekleştirebiliriz.
    //Ayni zaman da, shift, control, delete, enter gibi keyboard tuşlarina da actions yardımıyla basabiliriz. Bu tur işlemlerde sendKeys method u kullanilir.
    //2- Ne tür methodlar kullandin?
    //Actions methodlari önemlidir. Bu yüzden ve tekrar kullanmam gerektiginden, Actions method lari iceren Reusable methodlari olusturdum ve gerektiginde bu
    //Reusable method lari kullaniyorum. örnegin; doubleClick methodunu bir elemente cift tiklamak icin TestBase imden cagirabilirim
    //3- Hangi methodlari kullandin ne ne ise yarar?
    //Ornegin, sag tiklamak(contextClick()), çift tıklamak(doubleClick()), elementin uzerine gitmek(moveToElement()) gibi mouse islemlerini gerçekleştirebiliriz.
    //Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarina da actions yardımıyla basabiliriz. Bu tur islemlerde sendKeys method u kullanilir.

}
