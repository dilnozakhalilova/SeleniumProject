package Class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementFacebook {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Navigate to Facebook page
        driver.get("https://fb.com");

        Thread.sleep(2000);
        // let's practice using locators to locate web elements on facebook page:
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("password");
        Thread.sleep(2000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);

        //driver.findElement(By.linkText("Forgot password?")).click();
       // driver.findElement(By.partialLinkText("Forgot")).click();
         driver.findElement(By.partialLinkText("password?")).click();
        Thread.sleep(2000);



        //driver.close();

    }








}
