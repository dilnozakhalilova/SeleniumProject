package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormSubmission {
    public static void main(String[] args) throws InterruptedException {
        // System.setProperties("webdriver.chrome.driver","driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https:/www.google.com");
        Thread.sleep(2000);
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
        Thread.sleep(2000);
        driver.findElement(By.linkText("REGISTER")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstName")).sendKeys("Dilnoza");
        driver.findElement(By.name("lastName")).sendKeys("Khalilova");
        driver.findElement(By.name("phone")).sendKeys("112-456-4545");
        driver.findElement(By.id("userName")).sendKeys("test@gmail.com");
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();

        driver.quit();









    }
}