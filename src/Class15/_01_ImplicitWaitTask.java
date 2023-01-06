package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static utils.BaseClass.*;

/*
  Task: Get the text from a link which will load a paragraph when you click on it.
 *    1. Go to this URL: http://uitestpractice.com/Students/Contact
 *    2. Click on the link where it says 'This is a Ajax link'
 *    3. First use without wait, handle the exception, should say "Element is not found, Please wait longer for element to become visible".
 *    4. Wait for its content to load and retrieve the text from it and print it to the console.
 */
public class _01_ImplicitWaitTask {
    public static void main(String[] args) throws InterruptedException {

        setUp("http://uitestpractice.com/Students/Contact");
        //  driver.manage().window().maximize(); also in base class so no need to use here again

        // THIS IS A GLOBAL WAIT. APPLIES TO THE ENTIRE CLASS

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// if we set for 3 sec it will fail as it is too little time

        try {
            driver.findElement(By.linkText("This is a Ajax link")).click();
            System.out.println(driver.findElement(By.className("ContactUs")).getText());

        } catch (NoSuchElementException e) {
            System.out.println("Element is not found. Wait longer for the element to be visible");
        }

        tearDown();


    }

}

