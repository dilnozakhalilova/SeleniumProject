package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

public class _08_JSEecuterDemo extends BaseClass {
    public static void main(String[] args) {
        setUp("https://ebay.com");
        driver.findElement(By.linkText("Electronics")).click();  // on the ebay homepage we are selecting Electrinics menu.

        String script ="arguments[0].scrollIntoView(true);";  // This is  one of the JS scripts which can be copied from the web(i.e. StackOverFlow, Google or your cheatSheet)

        wait(2);

        WebElement popularCellPhones = driver.findElement(By.id("s0-27_1-9-0-1[4]-0-2-0-title"));  // We are scrolling down to 'Popular Cell Phones' section.
        ((JavascriptExecutor)driver).executeScript(script,popularCellPhones);


        wait(2);
        WebElement shopByCategory = driver.findElement(By.id("s0-27_1-9-0-1[1]-0-2-0-title"));  // We scroll up to 'Shop by Category' Section.
        ((JavascriptExecutor)driver).executeScript(script,shopByCategory);

        wait(2);

        // We click on 'Video Games' Link/category//a[@class='b-visualnav__tile b-visualnav__tile__default'])[6]
        driver.findElement(By.xpath("(//img[@class='b-img'])[9]")).click();   // We are clicking on the 'video Games & Consoles' category




        tearDown();

    }
}
