package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _11_InfiniteScroll extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Infinite Scroll")).click();
        wait(2);


        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = "window.scrollTo(0, document.body.scrollHeight)";

        while (paragraphs.size() < 20) {
            jsExecutor.executeScript(script);
            paragraphs = driver.findElements(By.className("jscroll-added"));
        }
        System.out.println("Total Paragraphs: " + paragraphs.size());
        wait(2);

        // after scrolling down for number of paragraphs, we are scrolling back to the top of the page using below code.
        jsExecutor.executeScript("window.scrollBy(0,-document.body.scrollHeight " +
                "|| -document.documentElement.scrollHeight)", ""); // StackOverflow

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

    public static int getNumberOfParagraph(){
        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        return paragraphs.size();
    }


}
