package RecapFromBegining.xPathDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPathDemo {
    private static String url = "https://exelentersdet.com//";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Exelent2022Sdet!");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@class,'panel')]")).click();

        Thread.sleep(2000);
        driver.close();


    }


}
