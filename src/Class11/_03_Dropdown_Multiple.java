package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

import static utils.BaseClass.*;
import static utils.BaseClass.tearDown;

public class _03_Dropdown_Multiple {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");
        WebElement months = driver.findElement(By.cssSelector("select[name='Month']"));
        Select select= new Select(months);
        List<WebElement> listOfMonths = select.getOptions();
        int totalMonths = listOfMonths.size();
        System.out.println("totalMonths = " + totalMonths);

        // Print all month using  1. For loop, 2. Enhanced Loop, 3. Iterator loop

        // Before looping we need to know the size/lengthof what we are about to loop

        System.out.println("===============For loop=================");
        for (int i = 0; i <totalMonths ; i++) {
            System.out.println(listOfMonths.get(i).getText());
        }

        System.out.println("===============For Each=================");
        for (WebElement month : listOfMonths) {
            System.out.println("month = " + month.getText());

        }
        System.out.println("===============Iterator=================");


        Iterator<WebElement> iterator= listOfMonths.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getText());
        }



        // Task2: Print only specific(selected month) from the list. For example, March, May, September
        // Hint:we can use the loop or we can use one of the existing Select class methods such as byVisibilityText(), by index/value

        // 1. without Select

        for (WebElement month : listOfMonths) {
          //  if(month.getText().equals("March"))
        }


        // 2. way:


        if(select.isMultiple()){
            select.selectByIndex(3);
            select.selectByVisibleText("May");
            select.selectByValue("Sept");
            Thread.sleep(2000);
            select.deselectByIndex(3);
            Thread.sleep(2000);
            select.deselectAll();
        }

        tearDown();
    }
}
