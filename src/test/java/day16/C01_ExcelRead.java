package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws IOException {
        //WORKBOOK(Excel dosyasi)> WORKSHEET/SHEET(Sayfa)> ROW> CELL
        String path = "./src/test/java/resources/Capitals.xlsx";

        //Dosyayi ac
        FileInputStream fileInputStream = new FileInputStream(path);

        //Excel dosyasini/Workbook ac
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Sayfayi/Sheet1 ac
        Sheet sheet = workbook.getSheet("Sheet1"); //Sheet sheet = workbook.getSheetAt(0); -> index sayisinin degisme olasiligi oldugu icin tavsiye edilmez.

        //Ilk row a git
        Row row1 = sheet.getRow(0);

        //Ilk satirdaki ilk veriyi al.
        Cell cell1 = row1.getCell(0); //getCell() okumak icin

        //Veriyi yazdir
        System.out.println(cell1);

        //1. satir 2. sutun a git
        Cell cell2 = sheet.getRow(0).getCell(1);
        System.out.println(cell2);
        System.out.println("cell2.getColumnIndex() = " + cell2.getColumnIndex()); //1

        //3. satir 1. sutun elemanini yazdir ve o verinin France oldugunu test et.
        String cell3 = sheet.getRow(2).getCell(0).toString();
        System.out.println(cell3);
        Assert.assertEquals("France", cell3);

        //Excel deki toplam satir sayisini bul
        int sumRowNumber = sheet.getLastRowNum()+1; //index 0 dan basladıgı icin 1 ekliyoruz
        System.out.println(sumRowNumber); //11

        //Fiziki olarak kullanilan toplam satir sayisini bul
        int sumRowUsedNumber = sheet.getPhysicalNumberOfRows();
        System.out.println(sumRowUsedNumber); //11

        //COUNTRY, CAPITALS key ve value lari map e alip print et
        //{Greece=Athens, Canada=Ottowa...}
        Map<String, String> capitals = new HashMap<>();
        for (int i = 1; i<sheet.getLastRowNum()+1; i++){ //sheet.getPhysicalNumberOfRows()
            String country = sheet.getRow(i).getCell(0).toString();
            String capital = sheet.getRow(i).getCell(1).toString();
            capitals.put(country, capital);
        }
        System.out.println(capitals);

        //Tum data yi yazdir.
        for (int i = 0; i<sheet.getLastRowNum()+1; i++){
            for (int j = 0; j<sheet.getRow(i).getPhysicalNumberOfCells(); j++){ //sheet.getRow(i).getLastCellNum()+1
                System.out.println(sheet.getRow(i).getCell(j));
            }
        }
    }

}
