package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

public class _05_ExplicitWait {
    public static void main(String[] args) {
        setUp("https://omayo.blogspot.com/");
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);// Declare and initialize the object of fluent wait
        fluentWait.withTimeout(Duration.ofSeconds(15));             // Wait for up to given time. In this case 15 sec
        fluentWait.pollingEvery(Duration.ofSeconds(1));             // Keep checking for the presence of element every 1 second
        fluentWait.ignoring(NoSuchElementException.class);          // do not throw given exeption until max time (15 sec) is reached

        driver.findElement(By.cssSelector("button[class='dropbtn']")).click();  // Locating dropdown button and click on it
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Facebook")));
        driver.findElement(By.partialLinkText("Face")).click();  // click on the facebook link and should take us to facebook homepage

        // NOTE: Think of Fluent Wait similar as Explicit wait, but with more controls

        tearDown();
    }
}
