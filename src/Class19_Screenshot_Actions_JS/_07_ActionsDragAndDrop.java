package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

public class _07_ActionsDragAndDrop extends BaseClass {
    public static void main(String[] args) {
        setUp("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        // 1. Way

        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();   // works without .build() as well
        wait(2);

        driver.navigate().refresh();
        // after this refresh above elements get detached from the DOM, you must relocate/reassign before you can use
        wait(2);


        // 2. Way
        draggable = driver.findElement(By.id("draggable"));  //reassigning/reattaching in the DOM again
        droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(draggable, droppable).perform();


        tearDown();

    }
}
