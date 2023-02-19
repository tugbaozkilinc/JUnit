package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

    static WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() {
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken dogum yilini, ayini, ve gununu su sekilde secer: 2000, January, 10
        WebElement year = driver.findElement(By.xpath("//*[@id='year']")); //locate dropdown element
        Select yearDropdown = new Select(year); //select objesi olustur
        //Select object i kullanarak 3 farkli sekilde secim yapabilirim;
        yearDropdown.selectByIndex(22); //secenek sirasi ve 1 den baslar.
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        Select monthDropdown = new Select(month);
        monthDropdown.selectByValue("0"); //value="0" January seceneginin value degerini yaziyoruz.
        WebElement day = driver.findElement(By.id("day"));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByVisibleText("10");
    }

    @Test
    public void printAllTest() {
        //Tum eyalet isimlerini consol a yazdir.
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();
        for (WebElement w : stateList){
            System.out.println(w.getText());
        }
        //stateList.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void getFirstSelectedOptionTest() {
        //State dropdown indaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim.
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropdown = new Select(state);
        String defaultText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State", defaultText);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    //1. What is dropdown? Dropdown nedir?
    //Dropdown liste olusturmak icin kullanilir.
    //2. How to handle dropdown elements? Dropdown nasil automate edilir?
    //-Dropdown'i locate ederiz
    //-Select object'i olustururum
    //-Select object'i ile istedigim secenegi secerim
    //NOT: Select object'i olusturma nedenim, dropdownlarin Select class'i ile olusturulmasi
    //3. Tum dropdown seceneklerini nasil print ederiz?
    //-Tum dropdown elementlerini getOptions() methodu ile listeye koyariz sonra secenekleri loop ile yazdirabiliriz.
    //4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
    //getFirstSelectedOption() secili olan secenegi return eder.
    
}
