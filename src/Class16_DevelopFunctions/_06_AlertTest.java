package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class _06_AlertTest {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/07/alert-test.html");
        // driver.findElement(By.cssSelector(".header-widget div a")).click();  // Click on Selenium menu, which will cause no alertException
        driver.findElement(By.id("simple")).click();
        waitInSeconds(1);
        System.out.println(getAlertText());

        acceptAlert();
        waitInSeconds(2);

        driver.findElement(By.id("confirm")).click();
        waitInSeconds(1);
        System.out.println(getAlertText());
        dismissAlert();

        waitInSeconds(2);
        driver.findElement(By.id("prompt")).click();
        sendAlertText("DK");
        waitInSeconds(1);
        System.out.println(getAlertText());
        acceptAlert();






        tearDown();
    }
}
