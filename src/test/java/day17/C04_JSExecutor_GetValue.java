package day17;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class C04_JSExecutor_GetValue extends TestBase {

    @Test
    public void getValueTest() {
        // https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");

        // Tarih kısmındaki Yazili metinleri al ve yazdır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = js.executeScript("return document.getElementById('hotelDates').value").toString(); // document.getElementById() driver.findElement(By.id()) ile ayni gorevi gorur; id si
                                                                                                               // verilen elementi bulur, value attribute unun degerini alir.
                                                                                                               // Burda value attribute unu aliyoruz, fakat ihtiyacin olan her attribute u alabilirsin
        System.out.println("The value in the box is: " + text);
        //getValueByJS("hotelDates"); ==> reusable method ile cozumu

        // document.querySelector("#hotelDates")
        // NOT: document.querySelector("p").value; -> TAG KULLANILABILIR
        // document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
        // document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR
    }

    // Interview Questions
    //  1 - JUnit ile baslikta hosgeldiniz yazisini nasil automate ederiz ?
    //     - Önce manuel olarak belirtilen siteyi test ederim.
    //     - " Hoşgeldiniz " yazısı anasayfada olduğunu varsayarak devam ediyorum.
    //     - Siteye login kısmından id,password gibi gerekli locate'ler alınarak login olurum.
    //     - " Hoşgeldiniz " yazısının locate'ini alıp getText() methodu ile textini alırım.
    //     - Daha sonra Assert methodlarını kullanarak doğrulama, karşılaştırma gibi automate'leri yaparım.
    //
    //    2 - Ne tur assert kullanirsin ?
    //     - Assert.assertTrue()
    //     - Assert.assertFalse()
    //     - Assert.assertEquals()
    //     - Bu methodları java'dan gelen contains() gibi methodlar ile destekleyerek gereksinimlere göre kullanırım.
    //
    //    3 - Bir sayfadaki  link sayisini nasil bulursunuz.
    //     - Linkler HTML kod bloklarında "a" tag'ı ile belirtilir ?
    //     - By.tagName("a") ile bunları findElements kullanarak bir liste atarım.
    //     - Daha sonra bu list'in java'dan gelen size() metdonu ile eleman sayısını alırım.
    //
    //    4 - En son linke nasil tiklarsiniz ?
    //     - Bunun bir kaç yolu vardır bunlardan aklıma gelenleri şu şekilde açıklayabilirim.
    //     - xPath ile locate alarak [] içerisine son linkin index numarasını yazabilirim.
    //     - Ya da daha dynamic olarak yukarıda olusturduğum olduğum list ile birlikte get(size()-1).click() yaparım.
    //     - size()-1 yaparım çünkü size() methodu bana listin sayısını verir ben son elemanın indexini almak istiyorum.
    //
    //    5 - Ekran goruntusunu nasil alirsiniz
    //     - Teknik olarak söylemek gerekirse ekran görüntüsünü seleniumdan gelen getScreenShotAs() methodunu kullanarak alırım.
    //     - Ama bu her seferinde yazmak için uzun bir kod olacağından dolayı bunun reusable methodunu olusturur onu kullanırım.
    //
    //    6 - Test base de ne tur reusable met lar kullanirsiniz ?
    //     - Kod üzerinde atomic bir yapı olusturmak adına gerekli her durum için reusable method olustururum.
    //     - Örneklemek gerekirse findlocate, screenshot, wait, actions, js executor, dropdown reusable methodları olabilir.
    //
    //    7 - Automation test % kac kullanirsiniz ?
    //     - Test prensibim olarak %80 Automation , %20 Manuel Test kullanırım.(Şirket ihtiyacına göre bu oran değişebiilir)
    //
    //    8 - Excel'de dosyalari nasil alirsiniz ?
    //     - Pom'a yüklediğim apache poi dependency’yi kullanarak, oradan gelen methodlar ile alırım.
    //         Ayrıntı isterlerse şayet
    //     - Şu anda direk aklıma canlı kod yazımı direk gelmeyebilir ama bu konu hakkında neler yapacağımı biliyorum.
    //       Şayet çalışma ortamında böyle bir gereksinim oluşursa eğitim notlarımdan faydalanarak kısa sürede
    //       bunun altyapısını hazırlayabilirim.

}
