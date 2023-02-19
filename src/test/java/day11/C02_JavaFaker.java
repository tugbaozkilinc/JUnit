package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName(); //first name datasi
        System.out.println(firstName);
        String lastName = faker.name().lastName();
        System.out.println(lastName);
        String username = faker.name().username();
        System.out.println(username);
        System.out.println(faker.name().title()); //meslek
        System.out.println(faker.address().city()); //sehir
        System.out.println(faker.address().state()); //eyalet
        System.out.println(faker.address().zipCode()); //posta code
        System.out.println(faker.address().fullAddress()); //full address
        System.out.println(faker.phoneNumber().cellPhone()); //cep telefon numarasi
        System.out.println(faker.internet().emailAddress()); //email
        System.out.println(faker.number().digits(15)); //15 haneli numara
    }

    //TEST DATA : kullanici adi, sifre, tel no, email, sehir, kredi kart no,...
    //Test datalari kimden alinir?
    //1. BA-Business analyst (Acceptance Criteria lari yazar)
    //2. Test Lead
    //3. Manual Tester
    //4. Tech Lead & Team Lead & Dev Lead
    //5. Developer
    //6. Database
    //7. API call lar
    //8. Documantasyonlar. Ornegin, API swagger documani.
    //9. Java Faker da fake data almak icin kullaniyoruz
    //NERDEN GELMEZ : end user-kullanicidan, scrum master

}
