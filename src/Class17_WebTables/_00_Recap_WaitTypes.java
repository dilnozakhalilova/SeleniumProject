package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.time.Duration;

import static utils.BaseClass.*;

public class _00_Recap_WaitTypes {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //  driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.findElement(By.linkText("Dynamic Controls")).click();
        CommonMethods.wait(1);
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        System.out.println("Checkbox is selected: " + checkbox.isSelected());  // false
        checkbox.click();
        System.out.println("Checkbox is selected: " + checkbox.isSelected());  // true
        CommonMethods.wait(1);
        WebElement button = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        System.out.println("Button text: " + button.getText());   // button ==> 'Remove' text
        button.click();
        String message = driver.findElement(By.id("message")).getText();
        System.out.println("message: " + message);

        System.out.println("Button text: " + button.getText());   // button ==> 'Add' text

        button.click();

        message = driver.findElement(By.id("message")).getText();
        System.out.println("message: " + message);



        tearDown();
    }
}
