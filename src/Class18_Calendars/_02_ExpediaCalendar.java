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



        tearDown();
    }
}
