package Class12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _01_AlertDemo {

    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/07/alert-test.html");

        // How to handle a simple alert
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
        Thread.sleep(2000);



        Alert alert = driver.switchTo().alert();
        String alertText =alert.getText();
        System.out.println("alertText = " + alertText);
        alert.accept();                                     // accept = "OK" Button
        Thread.sleep(2000);

        // Handling Confirmation Alert ===================//button[text()='Confirmation Alert']

        Thread.sleep(2000);
         driver.findElement(By.cssSelector("button#confirm")).click();
        Alert confirmationAlert = driver.switchTo().alert();  //NOTE: for all alert types we use the same .switchTo().alert();
        String confirmationAlertText = confirmationAlert.getText();
        System.out.println("confirmationAlertText: " + confirmationAlertText);
        Thread.sleep(2000);
        confirmationAlert.dismiss();                        // dismiss="Cancel" button

        // Handling Prompt Alert     =======================//button#prompt
        Thread.sleep(2000);
        driver.findElement(By.id("prompt")).click();        // Identify WebElement for the alert and click on it
        Alert promptAlert = driver.switchTo().alert();      // Switching to Alert (from the browser) to handle it
        String promptAlertText = promptAlert.getText();     // Getting the content/text of the Alert(not the browser)
        System.out.println("promptAlertText: " + promptAlertText);
        Thread.sleep(1000);                             // Add time only when needed( for visualization) optional
        promptAlert.sendKeys("Dilnoza");           // Sending text/value(typing) the input text box
        Thread.sleep(1000);


       // driver.findElement(By.xpath("")).getText(); // will get an ecception as first you need to handle the alert
        promptAlert.accept();                               // Press "OK" button to close the Alert

        // Let's verify out entered text
        String expectedText= "Dilnoza";// for negative testing change only here. Add something to the end or change the text
        String enteredText = driver.findElement(By.xpath("//div[contains(text(),'Dilnoza')]")).getText();
        System.out.println("enteredText = " + enteredText);
        if(enteredText.contains(expectedText))
            System.out.println("Text is entered successfully. Test Passed");
        else
            System.err.println("Text is NOT entered successfully. Test Failed");


        tearDown();
    }


}
