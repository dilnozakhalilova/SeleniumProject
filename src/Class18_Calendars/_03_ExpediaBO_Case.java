package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.driver;
import static utils.BaseClass.*;

public class _03_ExpediaBO_Case {
    public static void main(String[] args) {
        setUp("https://www.expedia.com/Flights");

        String departMonthAndYear = "May 2023";
        String departDay = "8";
        String returnMonthAndYear = "December 2023";
        String returnDay = "17";

        driver.findElement(By.xpath("//a[@href='?flightType=roundtrip']")).click();
        driver.findElement(By.id("d1-btn")).click();
        String monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();

        while (!monthAndYear.equals(departMonthAndYear)){
            WebElement element = driver.findElement(By.cssSelector(".uitk-calendar button:nth-child(2)"));//click for next month
            clickButWaitForClickability(element);
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();
        }

        List<WebElement> startDays = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]//button"));
        for (WebElement day: startDays) {
            if (day.getAttribute("data-day").equals(departDay)){
                System.out.println("Departing Day : " + monthAndYear +" " + day.getAttribute("data-day"));
                day.click();
                break;
            }
        }


        while (!monthAndYear.equals(returnMonthAndYear)){
            WebElement element = driver.findElement(By.cssSelector(".uitk-calendar button:nth-child(2)"));//click for next month
           clickButWaitForClickability(element);
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[2]")).getText();
        }

        List<WebElement> endDays = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[2]//button"));
        for (WebElement endDay: endDays) {
            if (endDay.getAttribute("data-day").equals(returnDay)){
                System.out.println("Return Day : " + monthAndYear +" " + endDay.getAttribute("data-day"));
                endDay.click();
                break;
            }
        }

        tearDown();
    }
}
