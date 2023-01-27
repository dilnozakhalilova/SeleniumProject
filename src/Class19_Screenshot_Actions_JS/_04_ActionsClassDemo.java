package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;

import static utils.BaseClass.*;

public class _04_ActionsClassDemo extends BaseClass {
    public static void main(String[] args) throws AWTException {
        setUp("https://www.ebay.com/");

        WebElement myEBay = driver.findElement(By.linkText("My eBay"));

        Actions actions = new Actions(driver);
        actions.moveToElement(myEBay).perform();

        // Once you hover over the element now you can verify anything on that page/dropdown
        String summaryText = driver.findElement(By.xpath("(//ul[@id='gh-ul-nav']//a)[1]")).getText();
        if (summaryText.contains("Summary"))

            System.out.println("Hover over myEBay worked");
        else
            System.out.println("Hover did not work");

        wait(1);
        WebElement electronicsMenu = driver.findElement(By.linkText("Electronics"));
        actions.moveToElement(electronicsMenu).perform();   // Hovers on 'Electronics' menu
        wait(1);
        actions.contextClick(electronicsMenu).perform();    // Right-click on 'Electronics' menu
        wait(1);
        // electronicsMenu.sendKeys(Keys.ESCAPE);                // Not working yet
        // actions.sendKeys(Keys.ESCAPE).build().perform();      // Not working yet

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        wait(1);

        driver.navigate().to("https://demoqa.com/buttons");   // We are navigating from Ebay to new website
        wait(1);

        // We are locating double click element named  'Double Click Me button' and double clicking on it
        actions.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();

        String doubleClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        if (doubleClickMessage.contains("You have done a double click")){
            System.out.println("You have a correct message");}
        else {System.out.println("Message not found");}


        wait(1);
        tearDown();

    }
}
