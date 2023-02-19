package practice.day11;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class P03_ReadExcel extends TestBase {

    @Test
    public void readExcelTest() throws IOException {
        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String path = "./src/test/java/resources/data.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");
        String email = sheet.getRow(1).getCell(1).toString();
        System.out.println(email);
        String password = sheet.getRow(2).getCell(1).toString();
        System.out.println(password);

        //https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");

        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='formBasicEmail']")).sendKeys(email, Keys.TAB, password, Keys.TAB, Keys.ENTER);

        //Login olduğumuzu doğrulayalım
        Assert.assertEquals("Erol Evren", driver.findElement(By.xpath("//*[@id='dropdown-basic-button']")).getText());
    }

}
