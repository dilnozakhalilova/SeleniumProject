package Day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _00_Recap {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Navigating to Amazon website
        driver.get("https://www.amazon.com");

        // maximazing the webpage
       // driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        String title = driver.getTitle();
        System.out.println("title = " + title);

        driver.close();




    }
}
