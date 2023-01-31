package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

import static utils.BaseClass.*;

/*
Test Case 2: Calendars (HW)
1. Open Chrome Browser
2. Navigate to URL: https://www.aa.com/
3. Select From → (LAX)
4. Select To → (JFK)
5. Number of passengers → 2
6. Select Depart → March 01, 2023
7. Select Return → April 15, 2023
8. Click ‘Search’ to see ticket prices
9. Close the browser.
 */
public class _05_HW_Task2 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://www.aa.com/");
        String departureAirport = "LAX";
        String arrivalAirport = "NYC";


        driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']")).sendKeys(departureAirport);
        wait(2);
        driver.findElement(By.id("aa-leavingOn")).sendKeys(arrivalAirport);
        List<WebElement> numberOfPassangers = driver.findElements(By.xpath("//select[@id='flightSearchForm.adultOrSeniorPassengerCount']/option"));
        for (WebElement numPassagers : numberOfPassangers ){
            numPassagers.sendKeys("2");
            wait(2);
        }

        tearDown();
    }
}
