package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;
import utils.ConfigsReader;


public class _01_LoginTest extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com");

        // This is without function, direct access, locate and use.
        // WebElement username = driver.findElement(By.id("txtUsername"));
        // userName.sendKeys("Admin");


        // Second Way, with function(Same as above)
        WebElement username = driver.findElement(By.id("txtUsername"));
        //sendText(username, "Admin"); Hard Coded
       sendText(username, ConfigsReader.getProperties("username"));// here username is a value from sendText() method
       //DOESN"T WORK=Fix it==>  CommonMethods.sendText(username, ConfigsReader.getProperties("username"));// here username is a value from sendText() method


        tearDown();
    }
/**
 * To access method of class from another class/package
 * 1. Import statically
 * 2. Extends nameOfClass
 * 3. NameOfClass.method()
 */

}
