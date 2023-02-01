package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;
import utils.CommonMethods;

import java.util.List;

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
public class _04_Task1Hw extends BaseClass {
    public static void main(String[] args) {
        setUp("https://www.delta.com/flight-search/book-a-flight");

        String departureMonth = "April";
        String departureYear = "2023";
        String departureDate = "13";
        String returnMonth = "May";
        String returnYear = "2023";
        String returnDate = "11";

        driver.findElement(By.id("calDepartLabelCont")).click();
        //List<WebElement> monthAndYear = driver.findElements(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']"));
        String month = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title']) [2] /span [1]")).getText();
        String year = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title']) [2] /span [2]")).getText();
        while (!month.equals(departureMonth)) {
            driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click(); //
            month = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title']) [2] /span [1]")).getText();
            year = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title']) [2] /span [2]")).getText();wait(1);


        }

        List<WebElement> days = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]//tbody//td/a"));
        for (WebElement day : days) {
            while (day.getText().equals(departureDate)) {
                System.out.println("Departure: " + day.getText() + " of " + month + "," + year);  // Departure: 13 of April, 2023
                day.click();
                break;
            }

        }
        System.out.println("=========================Arrival=============================");

        month = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title']) [1] /span [1]")).getText();
        year = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title']) [1] /span [2]")).getText();
        while (!month.equals(returnMonth) ) {
            driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click(); //
            month = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title']) [2] /span [1]")).getText();
            year = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title']) [2] /span [2]")).getText();



        }
        days = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]//tbody//td/a"));
        for (WebElement day : days) {
            while (day.getText().equals(returnDate)) {
                System.out.println("Arrival: " + day.getText() + " of " + month + "," + year);  // Return: 15 of August 2023
                day.click();
                break;

            }
        }

        tearDown();
    }
}