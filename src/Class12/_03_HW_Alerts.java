package Class12;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static utils.BaseClass.*;

public class _03_HW_Alerts {
    public static void main(String[] args) throws InterruptedException {

        setUp();//url=https://www.selenium.dev/documentation/webdriver/interactions/alerts/

        System.out.println("==================Simple Alert=====================");
        driver.findElement(By.linkText("See an example alert")).click();
        Alert simpleAlert = driver.switchTo().alert();
        String simpleAlertText = simpleAlert.getText();
        System.out.println("simpleAlertText: " + simpleAlertText);
        simpleAlert.accept();


        System.out.println("==================Confirm Alert=====================");
        driver.findElement(By.linkText("See a sample confirm")).click();
        Alert comfirmAlert = driver.switchTo().alert();
        System.out.println("ConfirmAlert Text: "+comfirmAlert.getText());
        comfirmAlert.dismiss();

        System.out.println("==================Prompt Alert=====================");
        driver.findElement(By.linkText("See a sample prompt")).click();
        Alert promptAlerts = driver.switchTo().alert();

        System.out.println("Prompt Alert Text: "+promptAlerts.getText());
        promptAlerts.sendKeys("Dilnoza");
        if(promptAlerts.getText().equals("Dilnoza"))
            System.out.println("Your text contains Dilnoza. Test Passed");
        else
            System.out.println("Your text DOES NOT contain Dilnoza. Test Failed");
        promptAlerts.accept();


        tearDown();

    }
}
