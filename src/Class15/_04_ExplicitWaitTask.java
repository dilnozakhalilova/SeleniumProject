package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

public class _04_ExplicitWaitTask {
    /*
    /**
 *  HW: Explicit Wait
 *    1. Go to this URL: "https://the-internet.herokuapp.com/dynamic_loading/2"
 *    2. Click on the 'Start' button, it will load Hello World text after some time.
 *    3. Using Explicit Wait (NOT implicit) wait for the Hello World text to become available.
 *    4. Once the element is visible, grab it and print it to the console.
 *    5. Close the browser.
 *      Bonus: Use Try-Catch in case if your automation fails, but your browser still does close. (Intentionally fail it = Negative Testing).
 */
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/dynamic_loading/2");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try{
            driver.findElement(By.linkText("Start")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
            System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());

        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("Element is not found. Wait longer for the element to be visible ");
        }

        tearDown();
    }
}
