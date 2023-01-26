package Class17_WebTables;
// Task:
/**
 * HW: Test Case: Add and then Delete added employee from the table
 * 1. Open Chrome Browser
 * 2. Navigate to URL www.exelentersdet.com
 * 3. Login to the website (Credentials are in your Properties file)
 * 4. Add an employee
 * 5. Verify employee has been added (By retrieving Employee ID).
 * 6. Go to Employee list
 * 7. Delete added employee (By employee ID - ID is unique, could be multiple employees with same name)
 * 8. Quit the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

import static utils.BaseClass.*;

public class _05_HwTask {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/symfony/web/index.php/auth/validateCredentials");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Exelent2022Sdet!");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

        driver.findElement(By.cssSelector("#btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Samantha");
        driver.findElement(By.id("lastName")).sendKeys("Smith");
        String employeeId = driver.findElement(By.id("employeeId")).getText();
        driver.findElement(By.id("btnSave")).click();
        CommonMethods.wait(1);

        if(employeeId.equals(driver.findElement(By.id("personal_txtEmployeeId")).getText())){
            System.out.println("New employess successfully added");
        }

        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        List<WebElement> pageNavigations = driver.findElements(By.xpath("(//a[@class='current'])[1]"));
        for (WebElement pageNavigation : pageNavigations) {
            System.out.println("pageNavigation: " + pageNavigation);
        }


//        while(!pageNavigation.isBlank() && !pageNavigation.isEmpty()){
//            System.out.println("1");
//            break;
//        }










        CommonMethods.wait(1);


        tearDown();
    }
}



























/*
Go to the website and add employee
save and veryfy that employee is added
Go to main page and find the employee
if needed check next pages(using while loop)
find employee by id and delete
 */