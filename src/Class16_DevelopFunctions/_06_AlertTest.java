package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import utils.CommonMethods;

import static utils.BaseClass.*;

public class _06_AlertTest {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/07/alert-test.html");
        // driver.findElement(By.cssSelector(".header-widget div a")).click();  // Click on Selenium menu, which will cause no alertException
        driver.findElement(By.id("simple")).click();
        CommonMethods.wait(1);
        System.out.println(getAlertText());

        acceptAlert();
        CommonMethods.wait(2);

        driver.findElement(By.id("confirm")).click();

        CommonMethods.wait(1);
        System.out.println(getAlertText());
        dismissAlert();

        CommonMethods.wait(2);
        driver.findElement(By.id("prompt")).click();
        sendAlertText("DK");
        CommonMethods.wait(1);
        System.out.println(getAlertText());
        acceptAlert();







        tearDown();
    }
}
