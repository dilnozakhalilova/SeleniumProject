package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

import static utils.BaseClass.*;

public class _02_ExpediaCalendar {   // remove/Flights from the URL
    public static void main(String[] args) {
       /*
        Let's say we want to pick these dates
        Depart: May 17th, 2023
        Returning: July 26th, 2023
         */
        setUp("https://www.expedia.com/Flights");

        String departMonthAndYear = "May 2023";
        String returnMonthAndYear = "August 2023";
        String startDay = "15;";
        String endDay = "1";

        // Click on the 'Departing' button/field to pop the calendar
        driver.findElement(By.cssSelector("h1[class='uitk-heading uitk-heading-3']")).click(); // Click elsewhere for the alert to go away.
        CommonMethods.wait(1);
        driver.findElement(By.id("d1-btn")).click();

        // From the opened calendar , find Month and Year and store in a String for later use
        String monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();


        while (!monthAndYear.equals(departMonthAndYear)) { //   xPath = //div[@class='uitk-calendar']//button[2]
           WebElement element= driver.findElement(By.cssSelector(".uitk-calendar button:nth-child(2)"));  // Click on the next button
            clickButWaitForClickability(element);
            CommonMethods.wait(1);
            // When we click next button it is no longer 'February 2023', it is 'March 2023' so we need to reassign again, store it again for validation inside the whileloop condition
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();
        }

        // Once you are on desired element(expected month and year) loop through days  (td) and get the text/value
        List<WebElement> days = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]//button"));

        for (WebElement day : days) {
            if (day.getAttribute("data-day").equals(startDay)) {

                System.out.println("Return: " + day.getAttribute("data-day") + " of " + monthAndYear);  // Return: 15 of August 2023
                day.click();
                break;
            }
        }


        CommonMethods.wait(1);

        while (!monthAndYear.equals(returnMonthAndYear)) { //
            driver.findElement(By.cssSelector(".uitk-calendar button:nth-child(2)")).click();  // Click on the next button
            CommonMethods.wait(1);
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();
        }

        // Selecting day for return
        days = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]//button"));
        for (WebElement day : days) {
            if (day.getAttribute("data-day").equals(endDay)) {

                System.out.println("Return: " + day.getAttribute("data-day") + " of " + monthAndYear);  // Return: 15 of August 2023
                day.click();
                break;
            }
        }

        // Once Depart and Return dates are selected, click on the 'Done'button
        driver.findElement(By.xpath("(//button[text()='Done'])[2]")).click();

        tearDown();
    }
}
