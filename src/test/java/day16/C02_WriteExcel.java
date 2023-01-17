package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {
        // WORKBOOK> WORKSHEET/SHEET> ROW> CELL> YAZ> KAYDET
        String path = "./src/test/java/resources/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");
        Row row1 = sheet1.getRow(0);
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);

        // Ilk satir 3. sutunu create et
        Cell cell = row1.createCell(2);

        // Nufus yaz
        cell.setCellValue("NUFUS");

        // 2. satir 3. sutuna 450000 yazdir
        sheet1.getRow(1).createCell(2).setCellValue("450000");

        // 3. satir 3. sutuna 350000 yazdir
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        // Kaydet
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }

}
