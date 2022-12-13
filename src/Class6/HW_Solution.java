package Class6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class HW_Solution {
    public static void main(String[] args) {
        setUp();

        driver.findElement(By.linkText("Checkboxes")).click();

        WebElement checkbox1 = driver.findElement(By.xpath("//form/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form/input[2]"));

        System.out.println("checkbox1 is displayed = " + checkbox1.isDisplayed()
                           +"\ncheckbox1 is enabled = " + checkbox1.isEnabled()
                           +"\ncheckbox1 is selected = " + checkbox1.isSelected());

        System.out.println("-------------------------------");


        System.out.println("checkbox2 is displayed = " + checkbox2.isDisplayed()
                            +"\ncheckbox2 is enabled = " + checkbox2.isEnabled()
                            +"\ncheckbox2 is selected = " + checkbox2.isSelected());

        tearDown();

    }



}
