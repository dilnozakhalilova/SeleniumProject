package Class14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

import static utils.BaseClass.*;

public class _01_WindowHandleDemo {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/windows");

        /**
         * How to handle new tabs and new WINDOWS in Selenium?
         * We have 2 methods for handling new tabs/windows.
         *    1. getWindowHandle()  ===> handles parent/ main window only
         *    2. getwindowHandles() ===> handles all windows/tabs including the parent window
         */
/**
 * WebDriver driver1 = new ChromeDriver();  //===> This  going to launch a unique session, only ONE parent
 *         driver.close();  //<-- this will kill only tab/ window which is in focus
 *         driver.quit();  //<-- this will kill the entire session which was  launched by we driver
 */


        System.out.println("Main Window Title : " + driver.getTitle());// main window title

        String windowHandle = driver.getWindowHandle();      // this will return parent window unique ID
        System.out.println("Main Window ID = " + windowHandle);// CDwindow- plus alphaNumeric value===> uniques ID of the window

        driver.findElement(By.linkText("Click Here")).click();// CTRL+D to copy

        // Focus is still in main/ parent window because we have not switched to the child window yet.
        // System.out.println(driver.getTitle());   //Which one will print here? Still parent

        Set<String> allWindows = driver.getWindowHandles(); // this will return unique ID's for ALL windows
        int allOpenWindows = allWindows.size();
        System.out.println("All Tabs currently open: " + allOpenWindows);
        System.out.println("=======================");
        //System.out.print(allWindows);

        //allWindows.forEach(System.out::println);      // <---- use ForEach() -  if you want to print them all on each new line

        // Using Iterator
        Iterator<String> iterator = allWindows.iterator();
        String mainWindow = iterator.next();
        String childWindow = iterator.next();
        System.out.println("mainWindow = " + mainWindow);
        System.out.println("childWindow = " + childWindow);

        System.out.println("====================");
        System.out.println("Get Title before switch: " + driver.getTitle());// still a parent Tab title


        // How to switch fosuc to the child window and print its Title-> first switch

        driver.switchTo().window(childWindow);// Switching from Parent window to child
        System.out.println("Get Tilte after : " + driver.getTitle());// child Tab title

        // if I call driver.close() in this line, which window/tab will close?

        Thread.sleep(1000);
        driver.close();                     // it should close child, because as of this in the FOCUS is on the child tab

        //  Thread.sleep(1000);
        // driver.close();   // still in child you have to switch back to parent to close it. if we try to close it again, child window is already closed and when it is not found we get noSuchWindow exception





        tearDown();
    }
}
