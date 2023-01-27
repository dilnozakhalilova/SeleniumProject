package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.BaseClass.*;

public class _04_ActionsClassDemo {
    public static void main(String[] args) {
        setUp("https://www.ebay.com/");

        WebElement myEBay = driver.findElement(By.linkText("My eBay"));

        Actions actions = new Actions(driver);
        actions.moveToElement(myEBay).perform();

        // Once you hover over the element now you can verify anything on that page/dropdown
        String summaryText = driver.findElement(By.xpath("(//ul[@id='gh-ul-nav']//a)[1]")).getText();
        if (summaryText.contains("Summary"))
            System.out.println("Hover over myEBay worked");
        else System.out.println("Hover did not work");


        tearDown();
    }
}
