package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

import static utils.BaseClass.*;

public class _03_DynamicTable_0 {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        // First we need to log in

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr")); //Xpath //table[@class="SampleTable"]//tr
        System.out.println("Number of rows1: " + rows.size());
        // Task: Selecting a specific row and performing action on it, such as, edit or delete it
        // Logic. Compare actual with expected, once match is found, click on the checkbox and then click on the delete button
        // mini task.
        // By.css ==> table.SampleTable tr td:nth-child(10)
        // By.xPath===> table[@class='SampleTable']//tr/td[10]


        // Getting Rows
        List<WebElement> rows1 = driver.findElements(By.cssSelector("table[class='SampleTable'] tr"));
        System.out.println("Number of rows1: " + rows1.size());
        System.out.println("Number of rows1 before deletion: " + rows1.size());

        // Task: Selecting a specific row and perform action on it, such as, edit or delete it.
        // String expectedValue = "Charles Dodgeson";
        String expected_Value = "Steve Johns";
        String expectedValue = "Steve Johns";

        // 1st way: Ufuk Code:
        List<WebElement> actualValues = driver.findElements(By.xpath("(//table[@class='SampleTable']//tr/td[2])"));
        for (int i = 0; i < actualValues.size(); i++) {
            if (actualValues.get(i).getText().equals(expected_Value)) {
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + (i + 1) + "]")).click();    // +1 We need to skip header,
                CommonMethods.wait(1);
                driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete")).click();
                CommonMethods.wait(1);
                break;
            }
        }

        List<WebElement> actualValue = driver.findElements(By.xpath("//table[@class='SampleTable']//tr/td[2]")); // Names column
        //Verify it is deleted or not
        rows1 = driver.findElements(By.xpath("//table[@class='SampleTable']//tr")); // re-calculating rows1 after deletion.
        System.out.println("Number of rows1 after deletion: " + rows1.size());
//        System.out.println("Number of rows1 after deletion: " + numOfRows2);
//        if (numOfRows2 == (rows1.size() - 1)) {
//            System.out.println("Deletion is successful.");
//        }

        // Task: Compare expected with Actual, once match is found, click on the checkbox and then click on the delete button.

        for (int i = 0; i < rows1.size(); i++) {
            // Logic: Step 1: if Name column contains expectedValue go ahead and click checkbox next to it.
            driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(" + i + ")")); // <== we can also use xPath version of this css
        }
        // 2nd way: Dilnoza Code
//        String expectedValue = "Clare Jefferson";
//        List<WebElement> actualValues = driver.findElements(By.xpath("//table[@class='SampleTable']//tr/td[2]"));
//        for (int i = 0; i < actualValues.size(); i++) {
//            if (actualValues.get(i).getText().equals(expectedValue)) {
//                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + (i+1) + "]")).click();
//                wait(1);
//                driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();//
//                wait(1);
//                break;
//            }
//        }


        //3rd way: Bahodur Code:

//        List<WebElement> tableName = driver.findElements(By.cssSelector("table.SampleTable tr td:nth-child(2)"));
//        //td[text() = 'Paul Brown']//preceding-sibling::td//input
//
//        for (int i = 0; i < tableName.size(); i++) {
//            if (tableName.get(i).getText().equals(expectedValue)){
//                driver.findElement(By.xpath("//td[text() = '" + tableName.get(i).getText() + "']//preceding-sibling::td//input")).click();
//            }
//        }

        // Step 2: locate 'Delete' button web element and click on it to delete selected name above
        // Step 3: Print all rows1 again, now you should have one less row.


        String expectedValue3 = "Clare Jefferson";
        List<WebElement> actualValues3 = driver.findElements(By.xpath("//table[@class='SampleTable']//tr/td[2]"));
        for (int i = 0; i < actualValues.size(); i++) {
            if (actualValues3.get(i).getText().equals(expectedValue3)) {
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + (i + 1) + "]")).click();
                CommonMethods.wait(1);
                driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();//
                CommonMethods.wait(1);
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
