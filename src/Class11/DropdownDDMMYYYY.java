package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.BaseClass.*;

public class DropdownDDMMYYYY {
    public static void main(String[] args) throws InterruptedException {
        setUp();
        //1. Find the element for the day from the dropdown
        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        Select selectDayDD = new Select(dayDD);
        selectDayDD.selectByVisibleText("25");


        //1. Find the element for the month from the DD
        WebElement monthDD = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        Select selectMonthDD = new Select(monthDD);
        selectMonthDD.selectByIndex(4);// April

        Thread.sleep(2000);
        //1. Find the element for the Year from the DD
        WebElement yearDD = driver.findElement(By.xpath("(//select[@class='year '])[1]"));
        Select selectYearDD = new Select(yearDD);
        selectYearDD.selectByValue("1985");

        // NOTE: NEVER TYPE ANY LOCATORS, such as XPATH,CSS. ALWAYS COPY-PASTE.

        tearDown();

    }


}
