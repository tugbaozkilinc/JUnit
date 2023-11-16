package day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class C02_WebTables extends TestBase {

    //Bir Web sayfasindaki web elementleri duzenlemek icin HTML tablo oluşturabiliriz
    //HTML tablo farkli sekillerde olusturulabilir ama genellikle <table>, <thead>, <tbody>, <tr>(satir), <th>(basliktaki hucre) ve <td>(body deki hucre) tag’leri kullanilir.

    Logger logger = LogManager.getLogger(C02_WebTables.class.getName());
    @Test
    public void table1Print() {
        // //table[@id='table1']//thead//tr , //table[@id='table1']//thead  basligi(ilk satiri) verir
        // //table[@id='table1']//thead//tr//th[3] , //table[@id='table1']//thead//tr//th//span[text()='Email'] basliktaki(ilk satirdaki) 3. hucreyi verir
        // //table[@id='table1']//tbody//tr[3]//td[2] Jason(body nin 3. satirinin 2. hucresini verir)
        //https://the-internet.herokuapp.com/tables adresine gidin.
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1: Table1’i print edin
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        logger.info(table1); //System.out.println(table1);
        List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']//td"));
        list.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void row3print() {
        //https://the-internet.herokuapp.com/tables adresine gidin.
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 2: 3. Row’ data larını print edin
        List<WebElement> row3 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void lastRowData() {
        //https://the-internet.herokuapp.com/tables adresine gidin.
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 3: Son row daki data ları print edin
        List<WebElement> lastRowData = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        lastRowData.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void field5Test() {
        //https://the-internet.herokuapp.com/tables adresine gidin.
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 4: 5. Column datalarini print edin
        List<WebElement> field5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        field5.forEach(t -> System.out.println(t.getText()));
    }

    public void printData(int rowNumber, int columnNumber) {
        //Task 5 : Iki parametreli bir Java method oluşturalım: printData
        //Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2, 3);  => 2nd row, 3rd column daki datayı print etsin
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement element = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + rowNumber + "]//td[" + columnNumber + "]"));
        System.out.println(element.getText());
    }

    @Test
    public void callPrintData() {
        printData(2, 3);
    }

}

