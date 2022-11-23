package _11_18_2022Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

        private static String url = "https://exelentersdet.com/";
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // window users add '.exe' at the end
            WebDriver driver = new ChromeDriver();
            driver.get(url);

            driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
            driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Exelent2022Sdet!");
            Thread.sleep(2000);
           // driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
            driver.findElement(By.xpath("//input[@value='LOGIN']")).submit();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();

            Thread.sleep(2000);
            //driver.findElement(By.xpath("//div[@id='welcome-menu']//a")).click();

            driver.findElement(By.xpath("//a[starts-with(text(),'Log')]")).click();

            
            Thread.sleep(2000);
            driver.close();
        }



    }

