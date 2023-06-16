package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {
        //WORKBOOK> WORKSHEET/SHEET> ROW> CELL> YAZ> KAYDET
        String path = "./src/test/java/resources/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row1 = sheet.getRow(0);
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);

        //Ilk satir 3. sutunu create et
        Cell cell = row1.createCell(2);

        //Nufus yaz
        cell.setCellValue("NUFUS");

        //2. satir 3. sutuna 450000 yazdir
        sheet.getRow(1).createCell(2).setCellValue("450000");

        //3. satir 3. sutuna 350000 yazdir
        sheet.getRow(2).createCell(2).setCellValue("350000");

        //Kaydet
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }

    //Excel Okuma
    //Excelden veriyi okumak icin hangi sırayla gitmem gerekir?
    //workbook > sheet > row > cell
    //Bir exceldeki top satir sayısı nasıl bulunur?
    //getLastRowNum()+1 ya da getPhysicalNumberOfRows();
    //Excel Yazdırma
    //Microsoft dosyalari ile iletişime gecmek icin apache poi dependencies kullanılır
    //Su anki projende exceli nasil kullandin?
    //Test caselerimde çeşitli datalar kullanıyorum. Ornegin kullanıcı adi, kullanıcı şifresi gibi dataları excelde tutuyoruz. Bu datalari test caselerde kullanmak icin
    //excelden çekiyorum ve test caselerimde kullanıyorum.
    //Datalari excelde tutmanın faydası, dataların derli toplu bir yerde olması, data güvenliği, data kayıplarına engel olmak.

    //Apache POI kütüphanesini projenize eklemek, Java programınızda Excel(Microsoft Documents) dosyalarıyla çalışmanızı sağlar. Örneğin, bir Excel dosyasını okuyabilir,
    //hücrelere erişebilir, değerlerini değiştirebilir, yeni hücreler ekleyebilir ve Excel dosyasını kaydedebilirsiniz.

}
