package Class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

//---//p[text()='© 2022 - Testing Controls']
public class _01_FramesDemo {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://www.uitestpractice.com/Students/Switchto");// single frame

        // I am identifying the web element and print it at the same line- all in one here
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'2022')]")).getText());


        // Trying to send test "SDET" to the farims input text-box
        // Note: Before interacting with a Frame, first we need t switch to it, then take action.Otherwise we get Exception
        /**
         * We can switch to a Frame using 3  different methods
         * 1. By index
         * 2. By ID or Name
         * 3. By Web Element of the frame/iframe
         */

        //1. By index
        driver.switchTo().frame(0);         /// Switch to frame by index---> website has only one frame

        //driver.findElement(By.id("name")).sendKeys("SDET");             // by css locator: input#name-->one line

        WebElement textElement = driver.findElement(By.id("name"));             // String inside variable. Same as above
        textElement.sendKeys("SDET");
        driver.switchTo().defaultContent();// To switch back to main page


        // Lets try to get the text of the main window/ browser without switching first
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'2022')]")).getText());


        Thread.sleep(2000);

        //2. By Name or ID

        driver.switchTo().frame("iframe_a");
        textElement.clear();                                // to clear SDET text
        textElement.sendKeys("QA Engineer");

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        // 3. By Frame Web Element

        WebElement webElement = driver.findElement(By.cssSelector("iframe[src='/Demo.html']"));// here we identify web element and store it in webelement variable
        driver.switchTo().frame(webElement);                // switch to frame by its element
        textElement.clear();                                // clear QA Engineer
        textElement.sendKeys("Frame by Web Element");




        tearDown();
    }

}
