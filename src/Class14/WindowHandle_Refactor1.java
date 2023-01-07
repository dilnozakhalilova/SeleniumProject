package Class14;

import org.openqa.selenium.WindowType;
import utils.ConfigsReader;

import java.util.Set;

import static utils.BaseClass.*;

public class WindowHandle_Refactor1 {
    public static void main(String[] args) {
        setUp("https://google.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://about.google/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://store.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://exelenter.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        Set<String> allWindows = driver.getWindowHandles();

        switchToWindow(ConfigsReader.getProperties("expectedTitle"), allWindows);


        tearDown();
    }

    public static void switchToWindow(String windowTitle, Set<String> windows) {
        for (String windowOrTab : windows) {
            String title = driver.switchTo().window(windowOrTab).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Window is found! Page Title: " + driver.getTitle() +  " URL: " + driver.getCurrentUrl());
            }
        }
    }


}
