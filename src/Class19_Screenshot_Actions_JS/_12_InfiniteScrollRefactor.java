package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _12_InfiniteScrollRefactor extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Infinite Scroll")).click();
        wait(2);

        scrollToParapraph(13);

        tearDown();

    }

    public static void scrollToParapraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor) driver;

        while (getNumberOfParagraph() < index) {
            jsExecutor.executeScript(script);  // scroll down by one <p> paragraph

        }
        System.out.println("Total Paragraphs: " + getNumberOfParagraph());
    }

    public static int getNumberOfParagraph() {
        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        return paragraphs.size();
    }


}
