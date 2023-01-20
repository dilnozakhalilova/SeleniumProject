package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.waitInSeconds;

public class _04_TableWithoutTableTag_1 {
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

        // Print rows
        List<WebElement> rows = driver.findElements(By.cssSelector("div.rt-tr-group"));
        int totalRows = rows.size();
        System.out.println("\nNumber of rows: " + totalRows);
        for (WebElement row : rows) {
            System.out.print( row.getText() + " | ");

        }
        int notEmptyRow = 0;
        int emptyRows = 0;
        for (int i = 0; i < rows.size(); i++) {
            if (!rows.get(i).getText().isEmpty()) {
                notEmptyRow = i;
            } else if (rows.get(i).getText().isBlank()) {
                emptyRows = i;

            }
        }
        System.out.println("emptyRows = " + emptyRows);
        System.out.println("notEmptyRow = " + notEmptyRow);

        // Get non empty rows text
        driver.findElement(By.cssSelector("button[id='addNewRecordButton']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Dilnoza");
        driver.findElement(By.xpath("(//input[@class=' mr-sm-2 form-control'] )[2]")).sendKeys("Khalilova");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Something@gmail.com");
        driver.findElement(By.xpath("(//input[@class=' mr-sm-2 form-control'])[3]")).sendKeys("34");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("125000");
        driver.findElement(By.id("department")).sendKeys("Dev/QA");
        driver.findElement(By.id("submit")).click();

        waitInSeconds(1);


        tearDown();
    }

}
