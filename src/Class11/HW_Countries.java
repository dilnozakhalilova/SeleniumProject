package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static utils.BaseClass.*;

public class HW_Countries {
    // Task: loop through the list of countries untill "Morocco" country is found, select and exit
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        WebElement month = driver.findElement(By.cssSelector("select[name='Month']"));
        Select select = new Select(month);
        List<WebElement> listOfMonth = select.getOptions();
        System.out.println("listOfMonth= " + listOfMonth.size());


        // This is the list we are given for test Case,required by the company or the project
        // lets assume the customer wants to see these mentioned month in the application.
        List<String> expectedList = new ArrayList<>();
        expectedList.add("March");
        expectedList.add("June");
        expectedList.add("November");
        expectedList.add("July");
        expectedList.add("December");


        if (expectedList.containsAll(listOfMonth))
            System.out.println("The list does match. The test Passed");
        else
            System.err.println("The list does not match. Test Failed");
// To fix the above problem first we need to store all month in form of String data type (from Webelement type) by using.getTest()

        List<String>actualList = new ArrayList<>();
        for (WebElement month1 : listOfMonth) {
            actualList.add(month1.getText());// i am storing the list of month(from Webelement) into String type
        }
        if(actualList.containsAll(expectedList))
            System.out.println("THE LIST DOES MATCH");
        else System.err.println("THE LIST DOES NOT MATCH");







        tearDown();
    }
}
