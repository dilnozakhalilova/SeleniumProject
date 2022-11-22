package Day5Mentoring;
/*
Scenario automate www.saucedemo.com

Navigate to www.saucedemo.com
enter valid username and passcode
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Demo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https:/www.saucedemo.com");

        driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("secret_sauce");

        driver.findElement(By.cssSelector("input.button")).click();
        driver.findElement(By.cssSelector("[aclass#Trigger")).click();

        Thread.sleep(2000);

        driver.close();







    }
}
