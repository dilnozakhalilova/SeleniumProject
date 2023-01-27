package Class19_Screenshot_Actions_JS;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utils.ConfigsReader;

import java.io.File;
import java.io.IOException;

import static utils.BaseClass.*;

/**
 * In Selenium4 we have two more new methods for taking screenshots
 * They are called:
 *  1. getScreenshotAs();
 *  2. getFullPageScreenshotAs();    <=== Thgis method is only available with Firefox driver
 *
 *  These methods are new to Selenium 4, and are not availabler in Selenium 3.
 *  Using thgis method we can take screenshots in two ways:
 *   1. Section-level screenshots, specific to particular webelement of the page
 *   2. Full-page screenshot, entire page
 *
 */

public class _02_ScreenshotSelenium4FireFoxWebdriver {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");


        // Log in to web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperties("password"));
        clickButWaitForVisibility(driver.findElement(By.id("btnLogin")));

// 2. getFullPageScreenshotAs(); for this one switch to firefo  from the properties file






        tearDown();
    }
}
