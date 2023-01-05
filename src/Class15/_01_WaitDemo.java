package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


import java.time.Duration;

import static utils.BaseClass.*;

public class _01_WaitDemo {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));      // Selenium 4. This is an Implicit wait, and it is Dynamic wait. If element is found in 5 sec it will not wait for full 20 sec
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);       // Old version of Selenium 3. Same thing as line above
        Thread.sleep(2000);


        try{
            driver.findElement(By.cssSelector("div#start button")).click();                     // Locate start button element and click on it
            WebElement helloWorld = driver.findElement(By.cssSelector("div#finish h4"));        // Locate Hello World webelement and store it in a variable
            System.out.println("Hello World Text: " + helloWorld.getText());                   // Printing text from element Hello World

        }
        catch(NoSuchElementException e){
            e.printStackTrace();
            System.out.println("element is not found. You might want to wait longer for it to appear");
        }

        tearDown();
    }

}
