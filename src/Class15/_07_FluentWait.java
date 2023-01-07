package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

public class _07_FluentWait {
    public static void main(String[] args) {


        setUp("https://omayo.blogspot.com/");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.findElement(By.cssSelector("button[class='dropbtn']")).click();  // Locating dropdown button and click on it
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Facebook")));  // We wait for facebook link to appear based on given condition
        driver.findElement(By.partialLinkText("Face")).click();  // click on the facebook link and should take us to facebook homepage


        tearDown();
    }

}
