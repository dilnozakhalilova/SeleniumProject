package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _01_WebTableDemo {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/tables");

        List<WebElement> rows = driver.findElements(By.cssSelector("table#table1 tbody tr"));
        System.out.println("Number of rows: " + rows.size());



        tearDown();
    }

}
