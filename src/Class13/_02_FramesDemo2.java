package Class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _02_FramesDemo2 {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://ui.vision/demo/webtest/frames/");

        // How to know how many links (or frames) in a given webpage?
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("allLinks.size() = " + allLinks.size());
        List<WebElement> allFrames = driver.findElements(By.tagName("frame"));
        System.out.println("allFrames = " + allFrames.size());


        // Switching to frame one and finding element in one line
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='frame_1.html'] ")));
        driver.findElement(By.name("mytext1")).sendKeys("Frame One");

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        // Switch to Frame 2
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='frame_2.html']")));
        driver.findElement(By.name("mytext2")).sendKeys("Frame Two");


        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        // Switching to Frame 5
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame_5.html")));
        driver.findElement(By.name("mytext5")).sendKeys("Frame Five");




        tearDown();
    }
}
