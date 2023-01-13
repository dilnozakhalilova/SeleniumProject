package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class _05_DropdownTest3 {
    public static void main(String[] args) {
        setUp("https://vitalets.github.io/combodate/");

        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        WebElement monthDD = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        WebElement yearDD = driver.findElement(By.xpath("(//select[@class='year '])[1]"));


        // Go and Select April 15th, 2012
        selectDdValue(dayDD,"15");
        selectDdValue(monthDD,"Apr");// We can use by index or visible text
        selectDdValue(yearDD,"2012");


        tearDown();
    }
}
