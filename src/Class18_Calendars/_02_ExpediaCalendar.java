package Class18_Calendars;

import org.openqa.selenium.By;

import static utils.BaseClass.*;

public class _02_ExpediaCalendar {
    public static void main(String[] args) {
       /*
        Let's say we want to pick these dates
        Depart: May 17th, 2023
        Returning: July 26th, 2023
         */
        setUp("https://www.expedia.com/Flights");

        // Click on the 'Departing' button/field to pop the calendar
        driver.findElement(By.id("d1-btn")).click();

        // From the opened calendar , find Month and Year and store in a String for later use
        String monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();


        while(!monthAndYear.equals("May 2023")){ //   xPath = //div[@class='uitk-calendar']//button[2]
            driver.findElement(By.cssSelector(".uitk-calendar button:nth-child(2)")).click();  // Click on the next button
            waitInSeconds(1);

            // When we click next button it is no longer 'February 2023', it is 'March 2023' so we need to reassign again, store it again for validation inside the whileloop condition
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();

        }


        tearDown();
    }
}
