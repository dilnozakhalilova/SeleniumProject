package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
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
      //  System.setProperty(ChromeDriverService.CHROME_DRIVER_APPEND_LOG_PROPERTY,"true"); // This line will get rid of extra error logs from the console

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));   // Implicit Wait. It is Dynamic and is prefered

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));  // Explicit wait

        try {
            driver.findElement(By.cssSelector("div[id='start'] button")).click();  //div#start button
            wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']/h4"),"Hello World!"));
            System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());   // cssLocator    "div#finish h4"

        } catch (NoSuchElementException e) { // Note: if you get this exception TimeOutException, replace with it or use parent "Exception"
            e.printStackTrace();
            System.out.println("Element is not found. Wait longer for the element to be visible ");
        }

        tearDown();
    }
}
