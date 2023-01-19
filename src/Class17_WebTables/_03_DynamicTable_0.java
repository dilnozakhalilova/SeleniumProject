package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.waitInSeconds;

public class _03_DynamicTable_0 {
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
        // By.css ==> table.SampleTable tr td:nth-child(10)
        // By.xPath===> table[@class='SampleTable']//tr/td[10]


        String expectedValue = "Clare Jefferson";
        List<WebElement> actualValues = driver.findElements(By.xpath("//table[@class='SampleTable']//tr/td[2]"));
        for (int i = 0; i < actualValues.size(); i++) {
            if (actualValues.get(i).getText().equals(expectedValue)) {
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + (i+1) + "]")).click();
                waitInSeconds(1);
                driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();//
                waitInSeconds(1);
                break;
            }


        }

        tearDown();
    }

}


//        WebElement checkboxesList = driver.findElement(By.xpath("//table[@class='SampleTable']//tr/td[1]"));
//      driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(" + i + ")")); // <== we can also use xPath version of this css
//        }
//
//        // Step 2: locate Delete web element and click on it to delete selected name
//        // Step 2: locate 'Delete' button web element and click on it to delete selected name above
//        // Step 3: Print all rows again, now you should have one less row.
