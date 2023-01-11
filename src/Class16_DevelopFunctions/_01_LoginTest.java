package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;
import utils.CommonMethods.* ;
import utils.ConfigsReader;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;
import static utils.ConfigsReader.*;



public class _01_LoginTest  {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com");

        // This is without function, direct access, locate and use.
        // WebElement username = driver.findElement(By.id("txtUsername"));
        // userName.sendKeys("Admin");


        // Second Way, with function(Same as above)
        WebElement username = driver.findElement(By.id("txtUsername"));
        //sendText(username, "Admin"); Hard Coded
        //sendText(username, ConfigsReader.getProperties("username"));// here username is a value from sendText() method
        sendText(username, ConfigsReader.getProperties("username"));// here username is a value from sendText() method

        WebElement password = driver.findElement(By.id("txtPassword"));
        sendText(password,ConfigsReader.getProperties("password"));

        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        //click(loginBtn);  //fix
        //loginBtn.click();
        //clickButWaitForClickability(loginBtn);
        clickButWaitForVisibility(loginBtn);



        tearDown();
    }
/**
 * To access method of class from another class/package
 * 1. Import statically
 * 2. Extends nameOfClass
 * 3. NameOfClass.method()
 */



}
