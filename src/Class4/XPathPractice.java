package Class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice
{
private static String url= "https://www.exelenter.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.id("txtUsername")).sendKeys("Ädmin");
        driver.findElement(By.name("txtPassword")).sendKeys("Exelent2022Sdet!");

        Thread.sleep(2000);

        driver.findElement(By.name("Submit ")).click();

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.close();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.quit();


    }





}
