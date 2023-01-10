package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

public class _09_WaitFromBaseClass {
    public static void main(String[] args) {
        setUp("https://omayo.blogspot.com/");

        driver.findElement(By.cssSelector("button[class='dropbtn']")).click();  // Locating dropdown button and click on it

       try {
           driver.findElement(By.partialLinkText("Face")).click();  // click on the facebook link and should take us to facebook homepage
       }catch (NoSuchElementException e){
           e.getStackTrace();
           System.out.println("Element is not Found. Please wait longer");
       }catch (Exception e){
           e.getStackTrace();
           System.out.println("Element if not found");
       }

        tearDown();
    }


}
