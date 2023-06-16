package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C02_Log4J {

    //Nasil eklenir?
    //Proje seviyesinde resources package i olustur, log4j2.xml(.xml uzantili olmak zorunda) adinda file olustur, verilen kodlari yapistir. Onemli bir dosya oldugunu belirtmek icin;
    //resources- sag tik- Mark Directory as- Test Resources Root

    //Log4J bilgileri console a ya da bir dosyaya yazdirmak(loglamak) icin kullanilan bir API dir; bilgi, hata ya da debug mesajlarini yazdirmak icin kullanilabilir.
    //Loglama anindaki zaman bilgisi alinabilir, dosyaya kalici olarak loglama islemi yapilabilir.
    //Farkli loglama cesitleri vardir:
    //logger.fatal("Fatal logger");
    //logger.error("Error logger");
    //logger.info("Info logger");
    //logger.debug("Debug logger");
    //Seviyeleri su sekilde: fatal> error> warn> info> debug> trace
    //1. dependency ekle
    //<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
    //<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
    //2. Logger object olustur: private static Logger logger = LogManager.getLogger(Demo.class.getName());
    //3. Object ile istenilen fonksiyonu kullan: logger.debug("Debug logger");
    //4. Consol daki loglari kontrol edelim. Default olarak fatal ya da error gorunmus olacaktir.

    //Log4j Nedir?
    //Loglama yani yazdırma islemi yapmak icin kullanılan bir API dir.
    //Cesitli seviyelerde loglama islemi yapılabilir: uyarı, bilgi, debug, hata mesajları icin kullanilabilir
    //Javadaki System.out.println e benzer, ama log4j ile dosyaya detaylı sekilde yazdırma islemi yapilabilir.
    //Su anda projemde log4j2 kullanmaktayım.

    Logger logger = LogManager.getLogger(C02_Log4J.class.getName());

    @Test
    public void log4JTest(){
        //logger objesi ile yazdirma islemini yap
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.info("Info Log!");
        logger.debug("Debug Log!");
    }

}
