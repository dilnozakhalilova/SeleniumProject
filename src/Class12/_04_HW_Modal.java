package Class12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static utils.BaseClass.*;

public class _04_HW_Modal {
    static String url = "https://www.selenium.dev/documentation/webdriver/interactions/alerts/";
    public static void main(String[] args) throws InterruptedException {
        setUp(url);

        System.out.println(driver.findElement(By.id("showLargeModal")).getText());

        driver.findElement(By.id("showLargeModal")).click();

        //driver.findElement(By.xpath("//button[@id='showLargeModal']")).click();// By x.path--> second option

        System.out.println(driver.findElement(By.xpath("//div[@class='modal-title h4']")).getText());

        System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());

        driver.findElement(By.xpath("//button[@id='closeLargeModal']")).click();

        tearDown();
    }
}
