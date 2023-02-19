package day13;

import utilities.TestBase;

public class C05_WebDriverException extends TestBase {

    /*
    WebDriverException:
    Driver ve browser versiyonları aynı veya yakın olmadığında alınır.
    Driver(Browser) i kapattıktan sonra tekrar kullanmak istediğimiz durumlarda alınabilir.
    Çözüm:
    Framework design inin güzel kurulmuş olması gerekir.
    Örn: driver sınıfında birden fazla driver.quit() olmamalı.
    */

    //Seleniumda aldigin 5 exception?
    //NullPointerException, no such elementException, time outException, staleElementReferenceException, WebDriverException
    //Genel olarak exception aldiginda cozum yolun nedir?
    //Hata mesajini oku
    //Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
    //Hata mesajina gore exception i cozdukden sonra tekrar kodumu calistiririm
    //Selenium da kullandigin waitler nelerdir>
    //Implicit ya da explicit ya da fluent
    //Hangi wait i tercih edersin?
    //Test Base(Driver sinifinda) implicit wait kullanıyorum. Cogu problemi cozuyor. Cozemedigi durumlarda explicit wait kullanıyorum.
    //Neden Explicit wait?
    //Explicit wait element e ozel yazilabilir. Yerel cozum gerektiğinde explicit wait i kullanmak zorundayiz.
    //Senkronize(bekleme) problemlerini nasıl çözersin?
    //Selenium wait lerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait kullanirim. Bu yüzden ReusableMethod
    //sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var. Kolaylıkla explicit wait ile bekleme problemlerini cozebiliyoruz.

}
