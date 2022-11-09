package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        // 1. establish a Connection with the driver(s)
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //2. Open the browser using the chrome driver's class constructor
        WebDriver driver = new ChromeDriver();// Launch browser for us(empty)

       // Navigate to Google website
        driver.get("https://google.com");


       String title = driver.getTitle();
       System.out.println("Title = " + title);

       String url= driver.getCurrentUrl();
       System.out.println("Url = " + url);


      // driver.quit();
        driver.close();

        System.out.println(" ==========================================");
        WebDriver driver2 = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver2.get("https://amazon.com");


        String title2 = driver2.getTitle();
        System.out.println("Title = " + title2);

        String currentUrl = driver2.getCurrentUrl();
        System.out.println("CurrentUrl = " + currentUrl);

        driver2.quit();


    }




}
