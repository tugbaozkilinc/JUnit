package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnitFirstTest {

    //Bilgisayar programlamada framework(yazılım iskeleti, yazılım çerçevesi), standart fonksiyonların hazır olarak sunulduğu ancak programcı tarafından bu fonksiyonlardan
    //arzu edilen kısımların ek kodlarla istenildiği şekilde güncellenebildiği sistemlerdir. Bu baglamda framework bizim calismak istedigimiz tool da olusturdugumuz, kutuphanemizin oldugu
    //calisma alanidir diyebiliriz, yani hangi tool u kullanirsaniz kullanin orda bir calisma alani dedigimiz framework u olusturmaniz lazim kullanmak istediginiz cerceveye gore, zaten
    //bunlarin belli bir standardi var aynisini kopyalayip yapistirirsiniz. Hangisini ne zaman kullanacaginiza eger bireysel calisiyorsaniz siz karar verirsiniz. Ama is dunyasinda sirket
    //hangi tool u kullaniyorsa ona gore framework kurar testlerinizi orda kosturursunuz. Framework bir çalışma prensibidir. Framework neyin nerede olacaginin belli olmasidir.
    //Bu sayede ortak calisma alani kurulmus olur.

    //Java ile en temel framework JUNit ile oluşturulabilir. Junit maven projesi uzerinde calistigindan  https://mvnrepository.com/ sitesinden dependency’leri projemize ekleriz.
    //Biz testlerimizi yapmak icin JUnit'in ileri sürümü olduğundan TestNG framework oluşturup kullanacagiz. Son framework olarak kuracagimiz Cucumber framework’da da Junit kullanacagiz.
    //Selenium da JUnit, TestNG, Cucumber framework leri vardır.

    //Annotation, bir veri hakkında bilgi barındıran veriyi sağlayan basit bir yapıdır. Bu sağladığı bilgiye de “metadata” denir.

    //@Test notasyonu eklemedigimiz method test sırasında çalıştırılmaz. Ancak cagrilirsa calisir. Before notasyonu, her test method’undan önce çalışır. After notasyonu, her test method’undan
    //sonra çalışmaktadır. @Ignore notasyonun tanımlı olduğu metotlar test sırasında çalıştırılmayacaktır. BeforeClass notasyonu, bir class’daki tüm testlerden once yapılması gereken bir islem
    //varsa kullanılır (precondition). AfterClass notasyonu da, bir class’daki tüm testler tamamlandıktan sonra yapılması gereken işlemlerde kullanılır.

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
    }

}
