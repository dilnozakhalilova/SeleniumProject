package Class14;

import org.openqa.selenium.WindowType;
import utils.ConfigsReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utils.BaseClass.*;

public class _02_WindowHandle2 {
    public static void main(String[] args) {
        setUp("https://google.com");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window: " + parentWindow);

        driver.switchTo().newWindow(WindowType.TAB);            // This will open a new blanck Tab and switch ( the focus) to it
        driver.get("https://about.google/");                    // This will open given URL in a new blank Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://store.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://exelenter.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");


        String expectedTitle = "Exelenter";
        Set<String> allWindows = driver.getWindowHandles();                       // This will store all TABS in a Set of Strings
        //allWindows.forEach(System.out::println);

        //List<String> windowList = new ArrayList<>(allWindows);
        // switchToWindow("Store",allWindows);
        //switchToWindow(expectedTitle, allWindows);
        switchToWindow(ConfigsReader.getProperties("expectedTitle"), allWindows);


        for (String window : allWindows) {
            if (!window.contains(parentWindow)) {
                System.out.println("This is the child window: " + driver.switchTo().window(window).getTitle());
            }
        }


        tearDown();

    }


    public static void switchToWindow(String windowTitle, Set<String> windows) {
        for (String windowOrTab : windows) {
            String title = driver.switchTo().window(windowOrTab).getTitle();
            // System.out.println("title: " + title);

            if (title.contains(windowTitle)) {
                System.out.println("Window is Found: " + driver.getTitle() + " URL: " + driver.getCurrentUrl());
            }

        }


    }

//    public static void switchToWindow2(String windowTitle, List<String> windowList) {
//        for (String windowOrTab : windowList) {
//            String title = driver.switchTo().window(windowOrTab).getTitle();
//            System.out.println("title: " + title);
//
//        }
//
//
//    }

}
