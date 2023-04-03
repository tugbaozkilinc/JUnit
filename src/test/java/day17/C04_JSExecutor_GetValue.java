package day17;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutor_GetValue extends TestBase {

    //-- JavascriptExecutor --
    //-- ID ILE LOCATE
    //JavascriptExecutor js = (JavascriptExecutor) driver;
    //WebElement element = (WebElement) js.executeScript("return document.getElementById('twotabsearchtextbox');");
    //WebElement backToTop = (WebElement) js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
    //js.executeScript("return document.getElementById('twotabsearchtextbox');") kodu, JavaScriptExecutor aracılığıyla belirli bir ID değerine sahip bir web elementini locate etmek için
    //kullanılan bir koddur. Bu kod, JavaScriptExecutor aracılığıyla tarayıcıda çalıştırılır ve getElementById() methodu kullanılarak 'twotabsearchtextbox' ID değerine sahip bir elementi
    //locate eder. Bu kodun döndürdüğü sonuç, locate edilen elementi temsil eden bir WebElement nesnesidir.
    //-- CSS SELECTOR ILE LOCATE
    //WebElement element = (WebElement) js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");

    @Test
    public void getValueTest() {
        //https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");

        //Tarih kısmındaki Yazili metinleri al ve yazdır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = js.executeScript("return document.getElementById('hotelDates').value").toString(); //document.getElementById() driver.findElement(By.id()) ile ayni gorevi gorur;
                                                                                                               //id si verilen elementi bulur, value attribute unun degerini alir. Burda
                                                                                                               //value attribute unu aliyoruz, fakat ihtiyacin olan her attribute u alabilirsin.
        System.out.println("The value in the box is: " + text);
    }

    @Test
    public void javascriptTest() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Arama bölümünde selenium aratınız
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement searchBox = (WebElement) js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        js.executeScript("arguments[0].value='selenium'", searchBox);
        searchBox.submit();

        //Back to top bölümüne kadar scroll yapınız
        WebElement backToTop = (WebElement) js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
        js.executeScript("arguments[0].scrollIntoView(true);", backToTop);
        waitFor(2);

        //Back to top bölümüne tıklayınız
        try {
            backToTop.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", backToTop);
        }
    }

    //Interview Questions
    //JUnit ile baslikta hosgeldiniz yazisini nasil automate ederiz?
    //Önce manuel olarak belirtilen siteyi test ederim. Siteye login kısmından username, password icin gerekli locate'leri alarak login olurum. "Hoşgeldiniz" yazısının locate'ini,
    //getText() methodu ile de text ini alırım. Daha sonra Assert method larını kullanarak doğrulama, karşılaştırma gibi automate'leri yaparım.
    //Ne tur assert kullanirsin?
    //Assert.assertTrue(), Assert.assertFalse(), Assert.assertEquals(). Bu method ları java'dan gelen contains() gibi methodlar ile destekleyerek gereksinimlere göre kullanırım.
    //Bir sayfadaki link sayisini nasil bulursunuz?
    //Linkler HTML kod bloklarında "a" tag'ı ile belirtilir. By.tagName("a") ile bunları findElements() kullanarak bir List<WebElement> a atarım. Daha sonra bu list'in java'dan gelen
    //size() methodu ile eleman sayısını alırım.
    //En son linke nasil tiklarsiniz?
    //xPath ile locate alarak [] içerisine son linkin index numarasını yazabilirim. Ya da daha dynamic olarak yukarıda olusturmuş olduğum list ile birlikte get(size()-1).click() yaparım.
    //Ekran goruntusunu nasil alirsiniz?
    //Ekran görüntüsünü seleniumdan gelen getScreenShotAs() method unu kullanarak alırım. Ama bu her seferinde yazmak için uzun bir kod olacağından dolayı
    //bunun reusable methodunu olusturur onu kullanırım.
    //Test base de ne tur reusable method lar kullanirsiniz?
    //Kod üzerinde atomic bir yapı olusturmak adına gerekli her durum için reusable method olustururum. Örneklemek gerekirse screenshot, wait, actions, js executor, dropdown
    //reusable method ları olabilir.
    //Automation test % kac kullanirsiniz?
    //Test prensibim olarak %80 Automation , %20 Manuel Test kullanırım.(Şirket ihtiyacına göre bu oran değişebilir)
    //Excel'de dosyalari nasil alirsiniz?
    //Pom'a yüklediğim apache poi dependency’yi kullanarak, oradan gelen methodlar ile alırım.
    //Ayrıntı isterlerse şayet; Workbook/Sheet/Row/Cell sırasıyla istedigim hucreye ulasır ve bu hucredeki datayı assertion isleminde ya da automation da kullanirim.

}
