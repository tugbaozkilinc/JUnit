package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    // Selenium ile windows uygulamalarını test edemiyoruz. Ama test etmek için JAVA kullanabiliriz;
    // Bilgisayarımızda bir dosya olup olmadığını(exist) kontrol etmek için Java'yı kullanabiliriz.

    @Test
    public void isExistTest() {
        // Masa ustunden bir dosyanın varligini test et
        String userDIR = System.getProperty("user.dir"); // icinde bulunulan klasörün yolunu(Path) verir.
        System.out.println(userDIR); // C:\Users\tugba\Desktop\JAVA\com.B103Maven_Junit
        String userHOME = System.getProperty("user.home"); // bilgisayarimizda bulunan user klasörünü verir.
        System.out.println(userHOME); // C:\Users\tugba

        // logo.jpeg indirip masaustune kaydedin.
        String filePath = userHOME + "\\Desktop\\logo.jpeg";
        System.out.println(filePath); // C:\Users\tugba\Desktop\logo.jpeg
        boolean isExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist);
    }

}
