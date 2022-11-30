package Class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindAllLinks {
    private static String url = "https://www.amazon.com";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get(url);
        Thread.sleep(5000);

        //IQ: find all existing links in a given website====> use the tag name to find it
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("allLinks = " + allLinks.size());
        int size = allLinks.size();
        System.out.println("size = " + size);

        // count and print all the links
//        for (WebElement link : allLinks) {
//            String linkText = link.getText();
//            System.out.println("linkText = " + linkText);
//
//        }

        // Task: Count and print all links that have text(do not print empty or blank links)
int count=0;
        for (WebElement link : allLinks) {
            String linkText = link.getText();
            if(!linkText.isEmpty() && !linkText.isBlank()){
                System.out.println( linkText);
                count++;
            }

        }
        System.out.println("Total with text"+count);







        Thread.sleep(2000);
        driver.close();

    }
}
