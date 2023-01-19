package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.waitInSeconds;

public class _03_DynamicTable_1 {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr"));
        System.out.println("Number of rows: " + rows.size());

        String expectedValue = "Mark";
        List<WebElement> actualValues = driver.findElements(By.xpath("//table[@class='SampleTable']//tr/td[2]"));// Names column

        for (int i = 1; i < rows.size(); i++) {
            if (rows.get(i).getText().contains(expectedValue)) {
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
            }

        }
        // Once you find expected value , click delete button and delete it
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        // Reprint number of rows after deletion
        rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr"));
        System.out.println("Number of rows: " + rows.size());


        System.out.println("==============================My Practice with Locators=======================================");
        System.out.println();


        driver.findElement(By.xpath("//ul[@id='ctl00_menu']/li[2]/a")).click();
        List<WebElement> secondTableRows = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr"));
        for (int i = 0; i <secondTableRows.size() ; i++) {
           if(secondTableRows.get(i).getText().contains("MyMoney")){
               List<WebElement> itemsInRow2 = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr[2]"));

           }

        }

        tearDown();
    }

}

