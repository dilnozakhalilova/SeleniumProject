package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class _02_RadioOrCheckboxTest {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");

        //Loop though all colors and select and click on Green Color
        List<WebElement> colorslist = driver.findElements(By.name("color"));

        List<WebElement> browserList = driver.findElements(By.name("browser"));

        String expectedValue="green";

        clickradioOrCheckbox(colorslist,expectedValue);
        clickradioOrCheckbox(browserList,"Mozilla");

//        for(WebElement color: colorslist){
//            String colorValue = color.getAttribute("value");// green will be retrieved
//            if(colorValue.equals(expectedValue)){
//                color.click();
//                break;
//            }
//        }

        tearDown();
    }

    }

