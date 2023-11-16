package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import java.util.List;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Homework03 extends TestBase {

    @Test
    public void test01() {
        //amazon gidin
        driver.get("https://www.amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//*[@title='Search in']"));
        Select searchBoxDropdown = new Select(searchBox);
        List<WebElement> list = searchBoxDropdown.getOptions();
        list.forEach(t -> System.out.println(t.getText()));

        //dropdown menude 28 eleman olduğunu doğrulayın
        Assert.assertEquals(28, list.size());

        //dropdown menuden elektronik bölümü seçin
        searchBoxDropdown.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        searchBox.sendKeys(Keys.TAB, "iphone", Keys.ENTER);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String text = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(text.contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement firstImage = driver.findElement(By.xpath("//*[@data-image-index='1']"));
        WebElement secondImage = driver.findElement(with(By.tagName("img")).toRightOf(firstImage));
        secondImage.click();

        //ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String productTitle = driver.findElement(By.xpath("(//*[@id='productTitle'])[1]")).getText();
        String productPrice = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();

        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        switchToWindow(1);
        driver.get("https://www.amazon.com");

        //dropdown’dan bebek bölümüne secin
        searchBoxDropdown.selectByVisibleText("Baby");

        //bebek puset aratıp bulunan sonuç sayısını yazdırın
        searchBox.sendKeys(Keys.TAB, "bebek puset", Keys.ENTER);

        //sonuç yazsının puset içerdiğini test edin
        String result = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(result.contains("puset"));

        //üçüncü ürüne relative locater kullanarak tıklayin
        WebElement secondProduct = driver.findElement(By.xpath("//*[@data-image-index='2']"));
        WebElement thirdProduct = driver.findElement(with(By.tagName("img")).below(secondProduct));
        thirdProduct.click();

        //title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String newProductTitle = driver.findElement(By.xpath("(//*[@id='productTitle'])[1]")).getText();
        String newProductPrice = driver.findElement(By.xpath("(//*[@class='a-offscreen'])[6]")).getText();
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
        driver.findElement(By.xpath("//*[@id='nav-cart-count']")).click();
    }

}
