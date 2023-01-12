package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static utils.BaseClass.driver;

/**
 * NOTE: This is our Bank for reusing methods elsewhere in the framework when we need it.
 * We stote all common methods for usability here. This will help us to avoid DRY principle of programming/coding.
 */


public class CommonMethods {
    /**
     * Method will Switch focus to next window/tab based on the window titl/name
     *
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

    public static void click(WebElement element) {
        element.click();
    }

    public static WebDriverWait waitForElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        return wait;
    }

    public static void clickButWaitForClickability(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static void waitForClickability(WebElement element) {
        waitForElement().until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void waitForVisibility(WebElement element) {
        waitForElement().until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitForVisibility(By by) {
        waitForElement().until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public static void clickButWaitForVisibility(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public static void clickradioOrCheckbox(List<WebElement> radiOrCheckBox, String expectedValue) {
        for (WebElement element : radiOrCheckBox) {
            String actualValue = element.getAttribute("value");
            if (actualValue.equals(expectedValue)) {
                element.click();
                break;
            }
        }
    }

    public static void selectFromDropbox(List<WebElement> dropboxSelection, String expectedValue) {
        for (WebElement element : dropboxSelection) {
            String actualValue = element.getText();
            if (actualValue.equals(expectedValue)) {
                element.click();
                break;
            } else {

            }
        }System.out.println("Test failed. Expected value does not match actual value");
    }

//    public static void selectDropDown(WebElement element, String expected) {
//        Select select = new Select(element);
//        for (int i = 0; i < select.getOptions().size(); i++) {
//            if (select.getOptions().get(i).getText().equalsIgnoreCase(expected)){
//                select.getOptions().get(i).click();
//                break;
//            }
//        }
//    }

}