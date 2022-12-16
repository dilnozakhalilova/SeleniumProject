package Class12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _01_AlertDemo {

    public static void main(String[] args) throws InterruptedException {
        setUp();// switch to URL: https://selenium08.blogspot.com/2019/07/alert-test.html


        // How to handle a simple alert
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
        Thread.sleep(2000);



        Alert alert = driver.switchTo().alert();
        String alertText =alert.getText();
        System.out.println("alertText = " + alertText);
        alert.accept();


        tearDown();
    }


}
