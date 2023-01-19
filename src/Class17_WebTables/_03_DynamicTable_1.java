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

        String expectedValue = "Charles Dodgeson";
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

