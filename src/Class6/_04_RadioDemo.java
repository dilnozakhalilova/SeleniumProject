package Class6;

/*
TC 4.1: Selecting Colors:
Open the Chrome browser
Go to provided “URL” page where checkboxes are present
Loop through the list of elements and find Yellow & Orange colors
Select both and print their names to the console
Close the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _04_RadioDemo {
    private static String url = "https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //We are retreaving the list of web elements
        List<WebElement> browsers = driver.findElements(By.xpath("//input[@name='browser']"));
        List<WebElement>colors = driver.findElements(By.xpath("//input[@name='color']"));

        for (WebElement color : colors) {
            String value = color.getAttribute("value");
            if (value.equals("orange") || value.equals("yellow")) {
                color.click();
                System.out.println("Yellow or Orange are found and selected");

            }
        }


        // Get the size of the list.
        int browserCount = browsers.size();
        System.out.println("browserCount = " + browserCount);// should return 3


        // iterate through the list and print them in the console

        //1. Regular Loop
        System.out.println("======================= Regular loop =======================");
        int count = 1;
        for (int i = 0; i < browsers.size(); i++) {

            String attributeValue = browsers.get(i).getAttribute("value");
            System.out.println(count + " . " + attributeValue);
        }
        // 2. For Each Loop(Enhanced Loop)
        System.out.println("======================= For Each Loop =======================");
        int count1 = 1;
        for (WebElement element : browsers) {
            String value = element.getAttribute("value");
            System.out.println(count1 + " . " + value);

        }
        System.out.println("========================================");
        // select element that is enables but not selected
        for (WebElement element : browsers) {
            if(element.isEnabled()&& !element.isSelected()){
                System.out.println(element.getAttribute("value"));
            }
        }
        // Loop through the list of webElements and when 'Opera' is found click on it
        for (WebElement element : browsers) {
            String value = element.getAttribute("value");
            if(value.equals("Opera")){
                element.click();
                System.out.println("Opera is found and selected");
                break;
            }
        }


        Thread.sleep(2000);
         driver.close();

    }
}
