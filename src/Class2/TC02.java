package Class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.navigate().to("https://www.exelenter.com");
        Thread.sleep(2000);

        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().refresh();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("exelenter")){
            System.out.println("Test passes. Website contains \"Exelenter\"");
        }else{
            System.out.println("Test failed. Wrong website");
        }

        // another way to verify
        boolean exelenter = driver.getCurrentUrl().contains("exelenter");
        System.out.println("exelenter = " + exelenter);// if pass true

        driver.close();

    }
}