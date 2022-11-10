package Day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC 1: Amazon Page Title Verification:
Open the chrome browser
Go to “https://www.amazon.xn--com-9o0a/
Verify expected Title “Whatever title will be…” is correct
Print the title to the console
Close the browser
 */
public class TC01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");


        // Retreave the title
        String title = driver.getTitle();
        System.out.println( title);


        // verify the title is correct(as ecpected). Verification before/withougt TestNG or JUnit

        String expectedTitle ="Amazon.com. Spend less. Smile more.";
        if(title.equals(expectedTitle)){
            System.out.println("Test Passed. The title is correct");
        }else{
            System.out.println(" Test failed. The title is not correct");
        }

        driver.close();
    }

}
