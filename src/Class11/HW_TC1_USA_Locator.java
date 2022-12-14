package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

public class HW_TC1_USA_Locator {
    public static void main(String[] args) throws InterruptedException{

        setUp();

        WebElement countryDD = driver.findElement(By.cssSelector("select[name='country']"));
        Select select = new Select(countryDD);

//        Thread.sleep(1000);
//        select.selectByVisibleText("United States of America");
//        System.out.println("select = " + select);


        List<WebElement> countries= driver.findElements(By.xpath("//*[@name='country']/options"));
        for (WebElement country : countries) {
            country.click();
            if(country.getText().equals("United States of America")){
                country.click();
                System.out.println("country = " + country.getText());
                break;
            }
        }

        for (WebElement country : countries) {
            country.click();
            if(country.getText().equals("Morocco")){
                country.click();
                System.out.println("country = " + country.getText());
                break;
            }
        }


        tearDown();
    }
}
