package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static utils.BaseClass.*;

public class _03_DynamicTable1 {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        // First we need to log in

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr")); //Xpath //table[@class="SampleTable"]//tr
        System.out.println("Number of rows: " + rows.size());

        // Task: Selecting a specific row and performing action on it, such as, edit or delete it
        // Logic. Compare actual with expected, once match is found, click on the checkbox and then click on the delete button
        // mini task.

        String expectedValue = "Charles Dodgeson";
        // By.css ==> table.SampleTable tr td:nth-child(10)
        // By.xPath===> table[@class='SampleTable']//tr/td[10]
        WebElement actualValues = driver.findElement(By.xpath("//table[@class='SampleTable']//tr/td[2]"));

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> checkboxRow = driver.findElements(By.xpath("(//table[@class='SampleTable']//tr/td/input)[" + i + "]"));
            if (expectedValue.equals(actualValues)) {
                checkboxRow.get(i).click();
            }


        }


        tearDown();
    }
}

//        WebElement checkboxesList = driver.findElement(By.xpath("//table[@class='SampleTable']//tr/td[1]"));
//
