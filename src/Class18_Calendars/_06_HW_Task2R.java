package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

import static utils.BaseClass.*;

public class _06_HW_Task2R extends BaseClass {
    public static void main(String[] args)  {
        setUp("https://www.delta.com/flight-search/book-a-flight");

        String departureMonth = "April";
        String departureDate = "13";
        String departureYear = "2023";

        String returnMonth = "May";
        String returnDate = "11";
        String returnYear = "2023";

        driver.findElement(By.id("calDepartLabelCont")).click();
        //List<WebElement> monthAndYear = driver.findElements(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']"));
        String month = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title'])[1]/span[1]")).getText();
        String year = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title'])[1]/span[2]")).getText();

        while (!(month.equals(departureMonth) && year.equals(departureYear))) {
            driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click(); // Click on the 'Next' arrow
            month = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title'])[1]/span[1]")).getText();
            year = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title'])[1]/span[2]")).getText();
            wait(1);
        }

        List<WebElement> days = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]//tbody//td/a"));
        for (WebElement day : days) {
            if (day.getText().equals(departureDate)) {
                System.out.println("Departure: " + day.getText() + " of " + month + ", " + year);  // Departure: 13 of April, 2023
                day.click();
                wait(1);
                break;
            }
        }

        System.out.println("=========================Arrival=============================");
        while (!(month.equals(returnMonth) && year.equals(returnYear))) {
            driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click();    // clicking on 'Next' arrow
            month = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title'])[1]/span[1]")).getText();
            year = driver.findElement(By.xpath("(//div[@class='dl-datepicker-title'])[1]/span[2]")).getText();
            wait(1);
        }

        days = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]//tbody//td/a"));
        for (WebElement day : days) {
            if (day.getText().equals(returnDate)) {
                System.out.println("Arrival: " + day.getText() + " of " + month + ", " + year);  // Return: 15 of August 2023
                day.click();
                wait(1);
                break;
            }
        }

        tearDown();
    }
}
