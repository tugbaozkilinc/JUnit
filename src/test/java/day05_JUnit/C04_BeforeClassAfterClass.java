package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    // @BeforeClass ve @AfterClass annotation lari sadece static method lar icin calisir.
    // @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method larinin hepsini ayni anda calistirip en son @AfterClass i calistiririz.
    // Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After i kullanir.


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Butun test lerden once calisti.");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Butun test lerden sonra calisti.");
    }

    @Before
    public void setUp() {
        System.out.println("Her testten once calisir");
    }

    @After
    public void teardown() {
        System.out.println("Her testten sonra calisir");
    }

    @Test
    public void test01() {
        System.out.println("Ilk test");
    }

    @Test
    public void test02() {
        System.out.println("Ikinci test");
    }

    @Test
    @Ignore
    public void test03() {
        System.out.println("Ucuncu test");
    }

}
