package Class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _04_NestedFrames {
    public static void main(String[] args) {
        setUp("https://ui.vision/demo/webtest/frames/");

        // First switch to parent frame which is Frame 3

        WebElement frame3 = driver.findElement(By.cssSelector("frame[src='frame_3.html']"));// locate frame 3
        driver.switchTo().frame(frame3); // switch to frame 3
        driver.findElement(By.name("mytext3")).sendKeys("Frame Three");     // locate element for  input textbox and send keyword


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'docs')]")));  // switchig to inner frame
        // Print from title
        String textFromTitle = driver.findElement(By.xpath("//div[text()='Form Filling Demo Page']")).getText();
        System.out.println("textFromTitle = " + textFromTitle);


        // Switch to frame 4

        driver.switchTo().defaultContent();  // Switching to main browser
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='frame_4.html']")));// switching to frame4
        driver.findElement(By.name("mytext4")).sendKeys("Frame Four");

        tearDown();
    }
}
