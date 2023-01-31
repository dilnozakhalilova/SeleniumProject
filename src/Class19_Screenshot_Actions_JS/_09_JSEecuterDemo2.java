package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

public class _09_JSEecuterDemo2 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Large & Deep DOM")).click();

        WebElement table = driver.findElement(By.id("large-table"));
        String script ="arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor)driver).executeScript(script,table);



        tearDown();

    }
}
