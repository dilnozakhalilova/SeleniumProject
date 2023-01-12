package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

public class _04_DropdownTest2 {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        String expectedText = "April";

        //Method 1 ==> without select class  (we need to locate all children within the dropdown===> List <WebElement>)
        List<WebElement> listOfMonths = driver.findElements(By.cssSelector("select[name='Month'] option"));
        selectDdValue(listOfMonths, expectedText);
        selectDdValue(listOfMonths, "July");  // hard coded

        // Method 2. ===> use Select Class( if DD is build with Select class and has options, use this approach
        // we only need to locate parent of dropdown
        WebElement monthsDD = driver.findElement(By.cssSelector("select[name='Month']"));
        selectDdValue(monthsDD, expectedText);      // Selecting by visible Text

        selectDdValue(monthsDD, 19);             // Selecting by index
        selectDdValue(driver.findElement(By.cssSelector("select[name='country']")),300);

        tearDown();

    }


}
