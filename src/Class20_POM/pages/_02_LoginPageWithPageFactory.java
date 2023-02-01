package Class20_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.BaseClass.driver;

// Note: This is just a template for LogInPage where we store everything related to log in page here, in this class
// In Page Object Model (POM) Design Patter we organize our code by pages. Each webpage will have its own class.
public class _02_LoginPageWithPageFactory {


    // Log in with PageFactory

// @FindBy() == driver.findElement()

    @FindBy(id = "txtUsername")      // Locating by ID
    public WebElement username2;

    @FindBy(name = "txtPassword")    // Locating by Name
    public WebElement password2;

    @FindBy(xpath = "//input[@id='btnLogin']")           // Locating by xPath
    public WebElement loginBtn2;

    public _02_LoginPageWithPageFactory(){
        PageFactory.initElements(driver,this);   // this==> refering to clas name ==>_02_LoginPageWithPageFactory.class

    }

    @FindBy(css = "#divLogo img")
    public WebElement logo;




}
