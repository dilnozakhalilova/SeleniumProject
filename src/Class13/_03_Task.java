package Class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

import static utils.BaseClass.*;

public class _03_Task {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://ui.vision/demo/webtest/frames/");

       // Task: Go to frame five and get the text from the link and print it to the console. Then click on the link

        driver.switchTo().frame(  driver.findElement(By.cssSelector("frame[src='frame_5.html']")));

        WebElement element = driver.findElement(By.linkText("https://a9t9.com"));
        System.out.println("element = " + element.getText());

        Thread.sleep(2000);
        element.click();

        tearDown();
    }
}
