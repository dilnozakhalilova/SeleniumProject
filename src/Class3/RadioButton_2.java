package Class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton_2 {

    private static String url = "https://formstone.it/components/checkbox/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);


        // checkobox One
        WebElement chkbox3 = driver.findElement(By.cssSelector("input#checkbox-3"));

        System.out.println("Is checkbox3 enabled? : " + chkbox3.isEnabled());
        // checkbox One
        WebElement checkboxOne =driver.findElement(By.xpath("(//input[@class='fs-checkbox-element'])[1]"));
        boolean checkBoxOneIsEnabled = checkboxOne.isEnabled();
        System.out.println("Checkboxtwo is enabled = " +  checkBoxOneIsEnabled);
// checkbox two
        WebElement checkboxTwo =driver.findElement(By.xpath("(//input[@class='fs-checkbox-element'])[2]"));
        boolean enabled = checkboxTwo.isEnabled();
        System.out.println("Checkboxtwo is enabled = " + enabled);
// checkbox three
        WebElement checkboxThree =driver.findElement(By.xpath("(//input[@class='fs-checkbox-element'])[3]"));
        boolean checkboxThreeIsenabled = checkboxTwo.isEnabled();
        System.out.println("Checkboxthree is enabled = " + enabled);

        Thread.sleep(2000);
        driver.close();


    }
}
