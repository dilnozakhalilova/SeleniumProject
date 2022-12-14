package utils;

import org.openqa.selenium.WebElement;

import java.util.Set;

import static utils.BaseClass.driver;

/**
 *  NOTE: This is our Bank for reusing methods elsewhere in the framework when we need it.
 *  We stote all common methods for usability here. This will help us to avoid DRY principle of programming/coding.
 */



public class CommonMethods {
    /**
     * Method will Switch focus to next window/tab based on the window titl/name
     * @param windowTitle String
     */
    public static void switchToWindow(String windowTitle) {
        Set<String> windows = driver.getWindowHandles();
        for (String windowOrTab : windows) {
            String title = driver.switchTo().window(windowOrTab).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Window is found! Page Title: " + driver.getTitle() + " URL: " + driver.getCurrentUrl());
                break;
            }
        }
    }
    public static void sendText(WebElement element, String value) {
        element.sendKeys(value);
    }



}
