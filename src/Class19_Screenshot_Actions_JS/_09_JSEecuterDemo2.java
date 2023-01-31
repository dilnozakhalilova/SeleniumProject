package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

public class _09_JSEecuterDemo2 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Large & Deep DOM")).click();
        wait(2);
        String script = "arguments[0].scrollIntoView(true);";
        // 1. Way. This will take us directly to the table, scrolling based on the element location.
        // WebElement table = driver.findElement(By.id("large-table"));
        //((JavascriptExecutor) driver).executeScript(script, table);


        // 2. Way. Scrolling based on exact coordinates where I want to move on the page
        ((JavascriptExecutor) driver).executeScript( "window.scrollBy(250,2500)");     // Exact coordinates: hard coded





       tearDown();

    }
}
