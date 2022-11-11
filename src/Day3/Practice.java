package Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        driver.get("https://www.google.com");

        driver.navigate().to("https://www.amazon.com");
        String title1 = driver.getTitle();
        System.out.println("Amazon title = " + title1);
        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);


        driver.navigate().back();
        driver.navigate().refresh();


        driver.get("https://www.yahoo.com");
        String title = driver.getTitle();
        System.out.println("Yahoo title = " + title);

        driver.manage().window().maximize();

        String currentUrl1 = driver.getCurrentUrl();
        System.out.println("currentUrl1 = " + currentUrl1);

        driver.quit();





    }



}
