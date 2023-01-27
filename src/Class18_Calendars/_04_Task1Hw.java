package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import static utils.BaseClass.*;

/**
 * Test Case 1: Calendars (HW)
 * 1. Open Chrome Browser
 * 2. Navigate to URL: https://www.delta.com/flight-search/book-a-flight
 * 3. Select Depart - Return
 * 4. Select departure as April 13, 2023
 * 5. Select return/arrival as August 15, 2023
 * 6. Print itinerary details in the console
 * 7. Close the browser.
 */
public class _04_Task1Hw {
    public static void main(String[] args) {
        setUp("https://www.delta.com/flight-search/book-a-flight");

        String departureMonthYear = "April 2023";
        String departureDate = "13";
        String returnMonthAndYear = "August 2023";
        String returnDate = "15";

        driver.findElement(By.id("calDepartLabelCont")).click();
        WebElement monthAndYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']"));

        while (!monthAndYear.equals(departureMonthYear)) {
            driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click();
            CommonMethods.wait(1);
            monthAndYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']"));
            break;
        }

        WebElement days = driver.findElement(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]"));
//
//    for(WebElement day : days){
//
//    }

        tearDown();
    }
}
