package Class19_Screenshot_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;
import utils.ConfigsReader;

public class _10_JSEecuterDemo3 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");

        WebElement usename = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));


        sendText(usename, ConfigsReader.getProperties("username"));
        sendText(password, ConfigsReader.getProperties("password"));

        wait(2);
        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
        jsExecuter.executeScript("arguments[0].style.backgroundColor='red'", password);

        wait(1);


        tearDown();

    }
}
