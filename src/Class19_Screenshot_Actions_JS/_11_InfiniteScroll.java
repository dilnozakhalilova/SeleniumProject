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
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");





       tearDown();

    }
}
