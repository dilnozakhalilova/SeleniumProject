package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class _05_ActionsKeyPresses extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Key Presses")).click();   // Click on Key Presses link
        wait(1);

        WebElement inputField = driver.findElement(By.id("target"));   // Locate input filed and store in a web element

        Actions actions = new Actions(driver);
        inputField.sendKeys("A");
        wait(1);
        inputField.sendKeys(Keys.SPACE);
        wait(1);
        inputField.sendKeys("B");
        wait(1);
        inputField.sendKeys(Keys.BACK_SPACE);   // Similar to Backspace(Windows) on your keybpoard, will delete char before it
        wait(1);
        inputField.sendKeys("C");
        wait(1);
        inputField.sendKeys(Keys.ARROW_LEFT);
        wait(1);
        inputField.sendKeys(Keys.SPACE, Keys.SPACE, Keys.SPACE);
        wait(1);
        inputField.sendKeys(Keys.ARROW_RIGHT,Keys.SPACE);
        wait(1);
        inputField.sendKeys(Keys.SHIFT+"abc");   // Combination pressing of Shift + letters. Capitalises all letters
        tearDown();

    }
}
