package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C02_Log4J {
    // Nasil eklenir?
    // Proje seviyesinde resources package i olustur, log4j2.xml adinda file olustur, verilen kodlari yapistir.

    // Log4J bilgileri console a ya da bir dosyaya yazdirmak(loglamak) icin kullanilan bir API dir; bilgi, hata ya da debug mesajlarini yazdirmak icin kullanilabilir
    // Loglama anindaki zaman bilgisi alinabilir, dosyaya kalici olarak loglama islemi yapilabilir
    // Farkli loglama cesitleri vardir:
    // logger.fatal("Fatal logger");
    // logger.error("Error logger");
    // logger.info("Info logger");
    // logger.debug("Debug logger");
    // Seviyeleri su sekilde: fatal> error> warn> info> debug> trace
    // 1. dependency ekle
    // 2. Logger object olustur:  private static Logger logger = LogManager.getLogger(Demo1.class.getName());
    // 3. Logger fonksiyonuyla istenilen fonksiyonu kullan: logger.debug("Debug logger");
    // 4. Consol daki loglari kontrol edelim. Default olarak error or fatal gorunmus olacaktir.

    // Log4j Nedir?
    // Loglama yani yazdırma islemi yapmak icin kullanılan bir API dir
    // Cesitli seviyelerde loglama islemi yapılabilir: uyarı, bilgi, debug, hata mesajları icin kullanilabilir
    // Javadaki System.out.println e benzer, ama log4j ile dosyaya detaylı sekilde yazdırma islemi yapabilir.
    // Su anda projemde log4j2 kullanmaktayım

    private static Logger logger = LogManager.getLogger(C02_Log4J.class.getName());

    @Test
    public void log4JTest(){
        // logger objesi ile yazdirma islemini yap
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.info("Info Log!");
        logger.debug("Debug Log!");
    }

    // Javascript Executor nedir?
    // Seleniumdan gelen ve javascript kodlarını calistirmaya yarayan bir interface dir. Normal selenium metotları yeterli olmadıgı durumlarda kullanilabilir.
    // Ne zaman ve nasıl kullandın?
    // Normal selenium metotları yeterli olmadıgı durumlarda kullanilabilir. Ornegin, bazı buttonlara tıklamada problem olabiliyor, yada belirli bir web elementin gorunur olacağı sekilde sayfanın kaydırma islemi, yada input kutularindaki değerleri almak icin kullanilabilir.
    // Sayfayi asagi veya yukarı kaydırma islemi seleniumda nasıl yapılır?
    // Seleniumdaki Actions yada javascript executor metotları ile kaydırma islemleri yapılabilir. Ornegin, actionslarda page_up, page_down, arrow_up, arrow_down metotlari ile yada js executordaki scrollintoview(true) ile yapılabilir. Ben olusturdugumuz reusable metotlarını kullanarak bu islemlile kolaylıkla yapabiliyorum
    // Bir kutucukdaki(input) elemanın metni nasıl alınabilir?
    // Javascript executor ile alabiliriz. Cunki js executor ile attribute degerlerini alma imkanımız var. getText() METORU BU DURUMLARDA CALISMAZ.
    // Selenium da click yaparken problem yasadigin oldumu?
    // Bazen yanlis locator, yada bekleme(wait) problemi gibi durumlarda problem yaşadım. Bazen gizli(hidden) elementlere tiklarkende problem yaşadım. Bu durumlarda javascript executor kullandım ve problemi cozdum.
    // Selenium atomayonunda ne tur problemler yaşadın?
    // TEKNIK PROBLEMLER :Yanlis locator,bekleme(wait), alert, iframe, captcha, pop-up seklindeki reklam bildirimleri,multiple window, hidden elementlere tiklama, …
    // TAKIMLA ILGILI PROBLEMLER: (Çok gundeme getirilmeme). Developer bazen bulduğum bunları kabul etmiyordu. Cozum: takımla beraber değerlendirip fikir birliğine variyorduk.

}
