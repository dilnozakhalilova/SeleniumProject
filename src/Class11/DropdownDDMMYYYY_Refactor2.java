package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

public class DropdownDDMMYYYY_Refactor2 {

    public static void main(String[] args) throws InterruptedException {
        setUp();

        findDate(4,"25","1985");// <---This is called Clean coding. All distructions are hidden elsewhere

        tearDown();
    }
    static void findDate(int month, String day, String year) {// US Date Format MM/DD/YYYY, Rest of the world uses DD/MM/YYYY
        WebElement monthDD = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        Select selectMonthDD = new Select(monthDD);
        selectMonthDD.selectByIndex(month);// April
        System.out.println("month = " + month);

        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        Select selectDayDD = new Select(dayDD);
        selectDayDD.selectByVisibleText(day);
        System.out.println("day = " + day);

        WebElement yearDD = driver.findElement(By.xpath("(//select[@class='year '])[1]"));
        Select selectYearDD = new Select(yearDD);
        selectYearDD.selectByValue(year);
        System.out.println("year = " + year);






    }





}