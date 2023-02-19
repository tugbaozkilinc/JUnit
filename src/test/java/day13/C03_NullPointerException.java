package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class C03_NullPointerException {

    /*
    NullPointerException:
    Değişkenleri oluşturup instantiate etmediğimizde alırız.
    Örn: driver = new ChromeDriver()'da "new" kelimesini kullanmadığımızda NullPointerException hatasını alırız.
    Çözüm:
    WebDriver driver = new ChromeDriver();
    Faker faker = new Faker();
    */

    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerExceptionTest() {
        driver.get("https://www.techproeducation.com"); //WebDriver driver = new ChromeDriver() yapmadığımız için NullPointerException hatasını alıyoruz.
    }

    @Test
    public void nullPointerExceptionTest2() {
        System.out.println(faker.name().fullName()); //Faker objesini oluşturup new Faker(); demediğimiz için NullPointerException hatasını alıyoruz.
    }

}
