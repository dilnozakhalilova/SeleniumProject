package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _04_TableWithoutTableTag_1 {
    public static void main(String[] args)  {
        setUp("https://demoqa.com/webtables");

        WebElement thead = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        //System.out.println("thead = " + thead.getText());


        tearDown();
    }

}
