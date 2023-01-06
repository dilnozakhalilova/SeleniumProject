package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static utils.BaseClass.*;


public class _03_ExplicitWaitTask {
    public static void main(String[] args)  {

        setUp("http://uitestpractice.com/Students/Contact");

        // THIS IS A  WAIT. APPLIES TO THE ENTIRE CLASS

       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));// This is the GLOBAL wait. Applies to the whole class.


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));// Explicit wait is not GLOBAL but rather waits for a specific condition of the element.

        try {
            driver.findElement(By.linkText("This is a Ajax link")).click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ContactUs")));   // This is EXPLICIT wait. Waiting on the copndition of visibility of an element
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ContactUs")));
            System.out.println(driver.findElement(By.className("ContactUs")).getText());

        } catch (NoSuchElementException e) {
            System.out.println("Element is not found. Wait longer for the element to be visible");
        }



        By by = By.className("ContactUs");




        tearDown();


    }

}

