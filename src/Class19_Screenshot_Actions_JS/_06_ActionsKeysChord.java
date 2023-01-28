package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

public class _06_ActionsKeysChord extends BaseClass {
    public static void main(String[] args) {
        setUp("https://google.com/");

        wait(1);
        driver.findElement(By.name("q")).sendKeys("Exelenter SDET");
        wait(1);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // another way to do above action
        driver.navigate().back();
        wait(2);

        // this is a shorter way, in one line.
        driver.findElement(By.name("q")).sendKeys("Exelenter SDET",Keys.ENTER);

        // another way
        driver.findElement(By.name("q")).sendKeys(Keys.chord("Exelenter SDET",Keys.ENTER));


        tearDown();

    }
}
