package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.waitInSeconds;

public class _04_TableWithoutTableTag_2 {
    public static void main(String[] args) {
        setUp("https://demoqa.com/webtables");
        // Entire header located as a single web element.
        WebElement thead = driver.findElement(By.cssSelector("div[class='rt-thead -header']"));
        //System.out.println(thead.getText());

        // Print columns:
        List<WebElement> columns = driver.findElements(By.cssSelector("div[class='rt-thead -header'] div div div:nth-child(1)"));
        int totalColumns = columns.size();
        System.out.println("Number of columns: " + totalColumns);
        for (WebElement column : columns) {
            System.out.print(column.getText() + " | ");
        }
        System.out.println();

        // Print rows
       // List<WebElement> rows = driver.findElements(By.cssSelector("div.rt-tr-group"));
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class=\"rt-tr-group\"]"));
        int totalRows = rows.size();
        System.out.println("Number of rows: " + totalRows);


        //Print  Rows that are not blank
        int count=0;
        for (int i = 0; i < rows.size(); i++) {
           if (!rows.get(i).getText().isEmpty() && !rows.get(i).getText().isBlank()) {
               count++;
           }

        }
        System.out.println("Number of NonEmpty rows: "+ count);






        tearDown();
    }

}
