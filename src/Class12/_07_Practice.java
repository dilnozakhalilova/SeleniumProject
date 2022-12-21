package Class12;

import org.junit.Assert;

import org.openqa.selenium.By;

import static utils.BaseClass.*;

public class _07_Practice {

    public static void main(String[] args) {
        setUp("https://www.selenium.dev/documentation/webdriver/interactions/alerts/#prompt");
        String textHead = driver.findElement(By.partialLinkText("JavaScript alerts")).getText();
        String expected = "JavaScript alerts, prompts and confirmations";

        Assert.assertEquals(textHead,expected,true);

        tearDown();
    }
}
