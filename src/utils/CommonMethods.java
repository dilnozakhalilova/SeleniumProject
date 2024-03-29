package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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

    /**
     * Method will clear and then send value to input fields
     *
     * @param element WebElement
     * @param value   String
     */
    public static void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static void click(WebElement element) {
        element.click();
    }

    /**
     * Method will wait for an element to load for a duration of time provided. This is a Static wait, please use with caution.
     *
     * @param second int
     */
    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

    /**
     * Method will wait for the given element based on the visibility of element
     *
     * @param by Locator
     */
    public static void waitForVisibilityOfElement(By by) {
        waitForElement().until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public static void clickButWaitForVisibility(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public static void waitForPresenceOfElement(By by) {
        waitForElement().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Method selects radio button or checkbox
     *
     * @param radiOrCheckBox List of Webelements for dropdown or radion buttons
     * @param expectedValue  String
     */
    public static void clickradioOrCheckbox(List<WebElement> radiOrCheckBox, String expectedValue) {
        for (WebElement element : radiOrCheckBox) {
            String actualValue = element.getAttribute("value");
            if (actualValue.equals(expectedValue)) {
                element.click();
                break;
            }
        }
    }
//    public static void clickRadioOrCheckbox(WebElement element) {
//        if (element.isEnabled() && !element.isSelected()) {
//            element.click();
//        }
//    }


    public static void selectFromDropbox(List<WebElement> dropboxSelection, String expectedValue) {
        for (WebElement element : dropboxSelection) {
            String actualValue = element.getText();
            if (actualValue.equals(expectedValue)) {
                element.click();
                break;
            } else {

            }
        }
        System.out.println("Test failed. Expected value does not match actual value");
    }

    /**
     * This method selects from the dropdown or multi-select by text value
     *
     * @param element       list of WebElement
     * @param expectedValue String
     */
    public static void selectDdValue(WebElement element, String expectedValue) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(expectedValue)) {
                select.selectByVisibleText(expectedValue);
                break;
            }
        }

    }

    /**
     * Method selects from dropdown by visible text
     *
     * @param dropDownList  List of EebElements
     * @param expectedValue String
     */
    public static void selectDdValue(List<WebElement> dropDownList, String expectedValue) {
        for (WebElement element : dropDownList) {
            String actualValue = element.getText();
            if (actualValue.equals(expectedValue)) {
                element.click();
                break;
            }
        }
    }

    /**
     * Method selects from dropdown by visible text
     *
     * @param dropDownList  WebElements
     * @param expectedValue int
     */
    public static void selectDdValue(WebElement element, int index) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        if (index < options.size()) {
            select.selectByIndex(index);
        } else {
            try {
                throw new IndexOutOfBoundsException(index);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("Incorrect Index used. Please use a number between 1 and  " + options.size());
            }

        }

    }

    public static void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            System.out.println("Alert is not present");
        }

    }

    public static void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            System.out.println("Alert is not present");
        }

    }

    public static void dismissAlert2() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            System.out.println("Alert is not present");
        }

    }

    public static void sendAlertText(String text) {
        try {
            driver.switchTo().alert().sendKeys(text);
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            System.out.println("Alert is not present");
        }


    }

    public static String getAlertText() {
        String alertText = " ";
        try {
            alertText = driver.switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

        return alertText;
    }

    public static void scrollToParapraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor) driver;

        while (getNumberOfParagraph() < index) {
            jsExecutor.executeScript(script);  // scroll down by one <p> paragraph

        }
        System.out.println("Total Paragraphs: " + getNumberOfParagraph());
    }

    public static int getNumberOfParagraph() {
        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        return paragraphs.size();
    }


    // more methods related to JS

    public static  JavascriptExecutor jsExecuter(){
        return   (JavascriptExecutor) driver;
    }
    /**
     * Method performs simple click based on Java script. Use this when regular Selenium click fails
     *
     * @param element WebElement that needs to be clicked on.
     */
    public static void jsClick(WebElement element) {
        jsExecuter().executeScript("arguments[0].click();", element);
    }

    /**
     * Method will scroll to the given element.
     *
     * @param element WebElement to be scrolled to
     */
    public static void scrollToElement(WebElement element) {
        jsExecuter().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Method will scroll both vertically (left and right) and horizontaly ( up & Down) based on given pixels.
     * @param horizontalPixel int
     * @param verticatPixel int
     */

    public static void scrollToElement(int horizontalPixel, int verticatPixel) {
        jsExecuter().executeScript("window.scrollBy(" + horizontalPixel + "," + verticatPixel + ")");
    }


    public static void takeScreenshot(String fileName) {
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;   // telling driver to allow screenshots
        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);   // actual value from the website

        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/"+fileName+".png"));// changing png to jpeg, make sure you rename dashboars2.. or it will override previous screen
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Screenshot is not taken");
        }
    }


}