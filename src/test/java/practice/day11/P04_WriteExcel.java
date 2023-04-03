package practice.day11;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P04_WriteExcel {

    String path = "./src/test/java/resources/data.xlsx";
    @Test
    public void test01() throws IOException {
        //Data isimli excel dosyasına yeni kullanıcı adı ve password ekleyelim
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");
        sheet.createRow(3).createCell(0).setCellValue("email");
        sheet.createRow(4).createCell(0).setCellValue("password");
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }

    @Test
    public void test02() throws IOException {
        //Yeni bir method da kullanıcı bilgileri başlığını silelim
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(4);
        Cell cell = row.getCell(0);
        row.removeCell(cell);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }

}
