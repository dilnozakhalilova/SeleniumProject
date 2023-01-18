package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import static utils.BaseClass.*;

public class _01_WebTableDemo {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/tables");

        List<WebElement> rows = driver.findElements(By.cssSelector("table#table1 tbody tr"));
        System.out.println("Number of rows: " + rows.size());

        System.out.println("========Printing rows using for each==========");
        for (WebElement row : rows) {
            String rowtext1 = row.getText();
            System.out.println("rowtext1 = " + rowtext1);
        }

        System.out.println("========Printing rows using iterator==========");
        System.out.println();

        Iterator<WebElement> iterator = rows.iterator();
        while(iterator.hasNext()){
            WebElement row = iterator.next();
            String rowText = row.getText();
            System.out.println( rowText);
        }

        System.out.println("========Printing rows with less line==========");
        System.out.println();

        Iterator<WebElement> iterator1 = rows.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next().getText());
        }
        System.out.println("=== Print number of columns ===");
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of columns: " + columns.size());

        for (WebElement column : columns) {
            System.out.print(column.getText() + " | ");
        }



        tearDown();
    }

}
