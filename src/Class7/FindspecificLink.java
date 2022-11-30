package Class7;
/*
Task:
TC 4.3: Print visible links from the Exelenter Homepage
     1. Open the Chrome browser
     2. Go to Exelenter Website
     3. Iterate through the links until you find "Enroll Now"
     4. Once expected keyword is found, print it and exit
     5. Close the browser
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class FindspecificLink {
   static String expectedText= "Enroll now";
    private static String url=" https://www.exelenter.com";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // Find all links on the Exelenter webpage
        List<WebElement> allLinksExelenter = driver.findElements(By.tagName("a"));
        System.out.println("allLinksExelenter = " + allLinksExelenter.size());

        // Store total number of links in int type
        int size = allLinksExelenter.size();
        System.out.println("size = " + size);

        // Count and print only the link with the text that says "Enroll now"
        int count =0;
        for (WebElement link : allLinksExelenter) {
            String linkText = link.getText();
            if (!linkText.isEmpty()) {
                System.out.println("linkText = " + linkText);
                count++;
            }
            if (linkText.contentEquals(expectedText)) {
                System.out.println("Expected phrase is found = " + linkText);
                break;
            }
        }
            System.out.println("total number of links with text " + count);


        Thread.sleep(2000);
        driver.close();


    }


}
