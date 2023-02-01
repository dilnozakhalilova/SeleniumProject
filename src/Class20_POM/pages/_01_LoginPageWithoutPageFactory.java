package Class20_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;
// Note: This is just a template for LogInPage where we store everything related to log in page here, in this class
// In Page Object Model (POM) Design Patter we organize our code by pages. Each webpage will have its own class.
public class _01_LoginPageWithoutPageFactory {


    // Log in page without using page Factoring

    public WebElement username = driver.findElement(By.id("txtUsername"));
    public WebElement password = driver.findElement(By.id("txtPassword"));

    public WebElement loginBtn = driver.findElement(By.id("btnLogin"));
    public WebElement logo = driver.findElement(By.cssSelector("#divLogo img"));









}
