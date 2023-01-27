package Class19_Screenshot_Actions_JS;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utils.ConfigsReader;

import java.io.File;
import java.io.IOException;

import static utils.BaseClass.*;

/**
 * In Selenium4 we have two more new methods for taking screenshots
 * They are called:
 * 1. getScreenshotAs();
 * 2. getFullPageScreenshotAs();    <=== Thgis method is only available with Firefox driver
 * <p>
 * These methods are new to Selenium 4, and are not availabler in Selenium 3.
 * Using thgis method we can take screenshots in two ways:
 * 1. Section-level screenshots, specific to particular webelement of the page
 * 2. Full-page screenshot, entire page
 */

public class _02_ScreenshotSelenium4 {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");


        // Log in to web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperties("password"));
        clickButWaitForVisibility(driver.findElement(By.id("btnLogin")));


        // 1. How to take screenshot of particular section, an element within a page.
        WebElement quickLaunge = driver.findElement(By.className("quickLaungeContainer"));
        File sourceFile = quickLaunge.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(sourceFile, new File("screenshots/quickLaunch1.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to take a screenshot");

        }

        // 2. How to take full page screenshot with Selenium 4 using Chrome browser. (There is no native support).

        //  driver.findElements(By.tagName("a")); // will return all links

        WebElement fullPageScreenshot = driver.findElement((By.tagName("html")));
        File sourceFullPage = fullPageScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(sourceFullPage, new File("screenshots/dashboardFullPage.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Screenshot not taken");

        }

        tearDown();
    }
}
