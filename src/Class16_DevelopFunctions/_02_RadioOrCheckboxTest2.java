package Class16_DevelopFunctions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class _02_RadioOrCheckboxTest2 {
    public static void main(String[] args) {
        setUp("https://demoqa.com/radio-button");

        List<WebElement> noRadioBtn = driver.findElements(By.id("noRadio"));






        tearDown();
    }

    }

