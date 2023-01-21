package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;
import utils.CommonMethods;

import java.util.List;

import static utils.BaseClass.*;


public class _01_SimpleCalendar extends BaseClass {
    public static void main(String[] args) {
        setUp("https://demoqa.com/date-picker");

        // Lets pick 10/17/2018
        // Click on the date piker field to activate calendar
        driver.findElement(By.id("datePickerMonthYearInput")).click();

        //Select month(s) from the calendar drop down
        WebElement monthDD = driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']"));
        selectDdValue(monthDD,"October");   // also by Index = 9

        // Pick year
        WebElement yearDD = driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
        selectDdValue(yearDD,"2023");      // text prefered as too many values present


        // Pick day
        List<WebElement> daysDD = driver.findElements(By.cssSelector("div.react-datepicker__week div"));
        selectDdValue(daysDD,"01");


        WebElement datePickerField = driver.findElement(By.id("datePickerMonthYearInput"));
        String pickerFieldText = datePickerField.getAttribute("value");
        System.out.println("Date picker input value:  " + pickerFieldText);


        tearDown();
    }
}