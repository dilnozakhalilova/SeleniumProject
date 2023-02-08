package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import java.util.List;

/**  HW: Actions Class
 *      1. Go to exelenter.com
 *      2. Hover over the 'Courses+' menu, and a sub-menu dropdown will open
 *      3. From the sub-menu select 'Java-sdet' and click on it
 *      4. On the Java SDET page, grab the title 'SDET Automation Course'
 *      5. Open a new tab and navigate to Google homepage on this newly opened tab
 *      6. On the Google search box, type "Exelenter" +  Title (concatenate), which you copied
 from the exelenter sdet page  (Step 4)
 *      7. Press Enter, and you will be taken to the Google Search result page
 *      8. From the Search Results, loop through until you find a link with the title 'Exelenter' click on it
 *      9. Now you should end up on the exelenter.com page again.
 *      10. Quit the browser.
 */


public class _13_HW_ActionClass extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelenter.com/");////li[@id='menu-item-8674']//span [1]
        Actions action = new Actions(driver);
        WebElement coursesTab = driver.findElement(By.linkText("Courses"));

        action.moveToElement(coursesTab).perform();
        List<WebElement> dropdownList = driver.findElements(By.xpath("//li[@id='menu-item-8674'] //a"));
        for(WebElement dropdownItem : dropdownList){
            if(dropdownItem.equals(driver.findElement(By.xpath("//li[@id='menu-item-9053']//span")))){
                dropdownItem.click();
                break;
            }
        }
        System.out.println("selected 'Java-sdet' and clicked on it");
        WebElement sdetElementText = driver.findElement(By.xpath("//div[@class='ct-title1 style4']//span"));
        System.out.println(sdetElementText.getText());
        wait(2);

        driver.switchTo().newWindow(WindowType.TAB).navigate().to("google.com");
        wait(1);


        tearDown();












    }
}
