package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _02_DynamicTable {
    public static void main(String[] args) {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");


        // First we need to log in

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr")); //Xpath //table[@class="SampleTable"]//tr
        System.out.println("Number of rows: " + rows.size());

        System.out.println("=====Print rows=======");

        for (WebElement row : rows) {
            System.out.println(row.getText());
        }

        System.out.println("======Print rows using regular For loop=======");
        System.out.println();
        // Note: Benefits of using for loop with web tables is that we can skip header. We hav e more control with "For Loop" how to iterate a list of web Elements
        for (int i = 1; i < rows.size(); i++) {                     // Instead of 0 we start printing from 1 because 0 holds header, which we do not want to print at this time
            System.out.println(rows.get(i).getText());
        }

        System.out.println("======= Print Columns==========");
        System.out.println();
        System.out.println("Total Number of columns: "+ driver.findElements(By.xpath("//table[@class='SampleTable']//tr[1]/th")).size());


        tearDown();
    }
}
