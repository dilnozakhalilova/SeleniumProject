package Day5Mentoring;
/*
Scenario automate www.saucedemo.com

Navigate to www.saucedemo.com
enter valid username and passcode
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_Lesson {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https:/www.saucedemo.com");

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("id=\"login-button\"")).click();

        Thread.sleep(2000);

        driver.close();







    }
}
