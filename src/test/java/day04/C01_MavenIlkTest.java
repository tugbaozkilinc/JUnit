package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {

        // Maven bir java derleme araci ve proje otomasyon ve yonetim aracidir. Maven dependency lerle ilgili mevcut jar dosyalarini otomatik olarak indirir.
        // Dependencies i pom dosyasina ekler ve pom dosyasindan yonetiriz. Projemizde dependencies i yonetmek icin pom u kullaniriz.
        // Tum projeyi yonetmemize yardimci olur. Drivers kurmak ve drivers lari olusturmak icin dependencies gereklidir. Gerekli araclari import eder.

        // Maven pom.xml ile github taki repo dan bizim icin lazim olan kutuphaneyi alicaz ve pom.xml (.xml uzantili bir dosya) in icine bu kod blogunu yapistiracagiz.
        // Bu kod blogu bana uzaktaki github tan o kutuphaneyi otomatik olarak indirecek. Bu kodlari mvnrepository.com den alicaz.
        // Remote repository den istedigimiz kutuphaneyi local repository mize pom.xml sayesinde çok rahat alacagiz.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // 2. Arama kutusunu locate edelim
        WebElement element = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        // 3. "Samsung headphones" ile arama yapalim
        element.sendKeys("Samsung headphones");
        element.submit();

        // 4. Bulunan sonuc sayisini yazdiralim
        WebElement searchResult = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")); // (//*[@class='sg-col-inner'])[1] bu şekilde multiple arama sonucundan ilkini list
                                                                                                                // olusturmadan alabiliriz. index le arama yapma css selector da yok xpath de var.
        System.out.println(searchResult.getText());

        // 5. Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        // 6. Sayfadaki tum basliklari yazdiralim
        List<WebElement> headersList = driver.findElements(By.xpath("//h1"));
        for (WebElement w : headersList){
            System.out.println(w.getText());
        }
        headersList.forEach(t -> System.out.println(t.getText()));

        driver.close();

    }
}
