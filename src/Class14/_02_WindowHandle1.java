package Class14;

import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static utils.BaseClass.*;

public class _02_WindowHandle1 {
    public static void main(String[] args) {
        setUp("https://google.com");

        System.out.println("Parent window: " + driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);            // will open a new blanck Tab and switch ( the focus) to it
        driver.get("https://about.google/");                    // This will open given URL in a new blank Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://store.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://exelenter.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");


        Set<String> allWindows = driver.getWindowHandles();                       // This will store all TABS in a Set of Strings
        System.out.println("How many Tabs open now:  " + allWindows.size());       // Getting total count of open tabs

        System.out.println("================================================");
        Iterator<String> iterator = allWindows.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            String nextWindow = iterator.next();
            //System.out.println("nextWindow = " + nextWindow); // This method doesn't care where the focus is, It will get the IDs regardless

            driver.switchTo().window(nextWindow);   // First we must switch to child window before we can get a title or perform an action on it
            String title = driver.getTitle();
            System.out.println(" Page " + count + " title: " + title);
            count++;

            // What if we want to switch focus to a specific tab or window
            List<String> windowList = new ArrayList<>();
            windowList.add(nextWindow);
            if (title.contains("Store")) {
                driver.switchTo().window(nextWindow);

                System.err.println("Window is found and switched to: " + driver.getTitle());
                System.err.println(" Unique ID: " + nextWindow);
               // break;
            }

        }

        tearDown();

    }


}
