package Class14;

import org.openqa.selenium.WindowType;

import java.util.Set;

import static utils.BaseClass.*;

public class _02_WindowHandle2 {
    public static void main(String[] args) {
        setUp("https://google.com");

        System.out.println("Parent window: " + driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);            // This will open a new blanck Tab and switch ( the focus) to it
        driver.get("https://about.google/");                    // This will open given URL in a new blank Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://store.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://exelenter.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");


        Set<String> allWindows = driver.getWindowHandles();                       // This will store all TABS in a Set of Strings
        allWindows.forEach(System.out::println);


        tearDown();

    }


}
