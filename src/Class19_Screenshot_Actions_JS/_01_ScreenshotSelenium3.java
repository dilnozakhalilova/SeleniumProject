package Class19_Screenshot_Actions_JS;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigsReader;


import java.io.File;
import java.io.IOException;

import static utils.BaseClass.*;

/**
 * In Selenium 3, we use interface 'TakesScreenshot' to take snapshots of webpages.
 * For copying file from source(webpage) to destination( your local folder) we can use either"
 * 1. FileUtils.copyFile(sourseFile, destinationFile)  <=== from Commons IO(input, output) and Apache Library
 * 2. FileHandler.copy(sourseFile, destinationFile)    <=== from Selenium library
 */


public class _01_ScreenshotSelenium3 {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");


        // Log in to web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperties("password"));
        clickButWaitForVisibility(driver.findElement(By.id("btnLogin")));


        // One way: Local explicit wait used here.

        // Before taking a screenshot wait for anyelement(yellow circle) to to become present
        // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));  // By convention should be on the top
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flot-overlay")));


        // Second way: we use one of the waits from the Common methods
         waitForPresenceOfElement(By.className("flot-overlay"));       // this method is coming from CommonMethods Class
        //waitForVisibilityOfElement(By.className("flot-overlay"));      // this method is coming from CommonMethods Class


        //3rd wait, hart way(hard coding). coming from Java not Selenium
        //  CommonMethods.wait(2);

        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;   // telling driver to allow screenshots
        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);   // actual value from the website

        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/dashboard6.jpeg"));// changing png to jpeg, make sure you rename dashboars2.. or it will override previous screen
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Screenshot is not taken");
        }


        tearDown();
    }
}
