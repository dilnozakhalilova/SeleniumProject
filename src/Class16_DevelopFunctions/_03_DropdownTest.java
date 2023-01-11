package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _03_DropdownTest {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        List<WebElement> listOfMonth = driver.findElements(By.cssSelector("select[name='Month'] option"));
         String expectedText="May";
        for(WebElement month: listOfMonth) {
            String actualText = month.getText();
            if(actualText.equals(expectedText)){
                month.click();
                break;

            }
        }





            tearDown();
    }

    }

