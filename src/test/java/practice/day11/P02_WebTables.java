package practice.day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P02_WebTables extends TestBase {

    @Test
    public void webTablesTest() {
        //1. https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //2. Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        List<WebElement> list = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr"));
        list.forEach(t -> System.out.println(t.getText()));

        //3. Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        System.out.println(driver.findElement(By.xpath("//table[@border='1']//tbody//tr[2]")).getText());
        int row = 1;
        for (WebElement w : list) {
            if(w.getText().contains("601")){
                System.out.println("In the table " + row + ". row: " + w.getText());
            }
            row++;
        }
        driver.findElements(By.xpath("//table[@border='1']//tbody//tr")).stream().filter(t -> t.getText().contains("601m")).forEach(t -> System.out.println(t.getText()));

        //4. Bütün Height bilgilerini yazdırınız
        List<WebElement> heightList = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr//td[3]"));
        heightList.forEach(t -> System.out.println(t.getText()));

        //5. Otel uzunluklarının hepsini toplayınız
        List<String> textList = new ArrayList<>();
        for (WebElement w : heightList){
            textList.add(w.getText());
        }
        int sum = 0;
        for (String w : textList) {
            sum += Integer.parseInt(w.replace("m", ""));
        }
        System.out.println(sum);

        //6. Bir method ile satır ve sutun bilgilerini çağıralım
        findTableMethod(3, 3);
    }

    public void findTableMethod(int row, int column){
        List<WebElement> list = driver.findElements(By.xpath("//table[@border='1']//tbody//tr[" + row + "]//td[" + column + "]"));
        list.forEach(t -> System.out.println(t.getText()));
    }

}
