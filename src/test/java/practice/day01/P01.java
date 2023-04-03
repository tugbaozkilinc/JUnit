package practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    public static void main(String[] args) {

        //Note: Su an maven projesinde bu testi yapiyoruz. Junit(framework) ile yapmiyoruz. Maven projesi icinde JUnit, Cucumber, TestNG framework leri var.
        //Kullanim sekilleri farkli. Su an biz framework olmadan maven i en sade haliyle kullaniyoruz. Ama daha once maven i en ilkel haliyle kutuphanemizi kendimiz yukleyerek kullaniyorduk.
        //Daha sonra bonigarcia nin WebDriverManager ismindeki kutuphanesini pom.xml imize ekleyerek o kutuphaneyi otomatik olarak kullanmaya basladik.(Su an bu sekilde kullaniyoruz)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual title is: " + actualTitle);
        System.out.println("Actual url is: " + actualUrl);

        //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("Spend") && actualUrl.contains("Spend"));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolTitle = driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Sitesi"));

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.quit();
    }

}
