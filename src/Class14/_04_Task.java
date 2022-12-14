package Class14;

import org.openqa.selenium.By;

import java.util.Set;

import static utils.BaseClass.*;
/*
 *  Task: Go to this URL: https://the-internet.herokuapp.com/windows
 *     1. Identify and print parent window ID and Title
 *     2. Click on the link where it says 'Click Here' three times
 *     3. Switch to new tabs and print their title to the console as well.
 *          Bonus: Load facebook website in all children pages.
 */

public class _04_Task {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/windows");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window ID:  " + parentWindow + " Title: " + driver.getTitle());


        for (int i = 0; i < 3; i++) {
            driver.findElement(By.linkText("Click Here")).click();
            Thread.sleep(1000);

        }
        Set<String> allWindowsOrTabs = driver.getWindowHandles();

        for (String tab : allWindowsOrTabs) {
            if (!tab.contains(parentWindow)) {
                System.out.println("This is a new TabOrWindow: " + driver.switchTo().window(tab).getTitle());
                driver.get("https://facebook.com");
                System.out.println("Child new Name: " + driver.getTitle() + " URL: " + driver.getCurrentUrl());
            }
        }
        tearDown();
    }

}
