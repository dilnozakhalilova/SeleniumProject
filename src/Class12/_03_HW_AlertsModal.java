package Class12;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static utils.BaseClass.*;

public class _03_HW_AlertsModal {
    public static void main(String[] args) throws InterruptedException {
        setUp();
        System.out.println("==================Simple Alert=====================");
        driver.findElement(By.linkText("See an example alert")).click();
        Alert simpleAlert = driver.switchTo().alert();
        Thread.sleep(1000);
        String simpleAlertText = simpleAlert.getText();
        System.out.println("simpleAlertText: " + simpleAlertText);
        simpleAlert.accept();

        Thread.sleep(2000);
        System.out.println("==================Confirm Alert=====================");
        driver.findElement(By.linkText("See a sample confirm")).click();
        Alert comfirmAlert = driver.switchTo().alert();
        Thread.sleep(1000);
        System.out.println("ConfirmAlert Text: "+comfirmAlert.getText());
        comfirmAlert.dismiss();


        Thread.sleep(2000);
        System.out.println("==================Prompt Alert=====================");
        driver.findElement(By.linkText("See a sample prompt")).click();
        Alert promptAlerts = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println("Prompt Alert Text: "+promptAlerts.getText());
        promptAlerts.sendKeys("Dilnoza");
        if(promptAlerts.getText().equals("Dilnoza"))
            System.out.println("Your text contains Dilnoza. Test Passed");
        else
            System.out.println("Your text DOES NOT contain Dilnoza. Test Failed");
        Thread.sleep(2000);
        promptAlerts.accept();


        tearDown();

    }
}
