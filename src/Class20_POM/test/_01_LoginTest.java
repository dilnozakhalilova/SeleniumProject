package Class20_POM.test;

import Class20_POM.pages._01_LoginPageWithoutPageFactory;
import Class20_POM.pages._02_LoginPageWithPageFactory;
import utils.BaseClass;
import utils.ConfigsReader;

public class _01_LoginTest extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");

        // Note: Make sure to comment out one before using the other.

//        // Without PageFactory


        var loginPage = new _01_LoginPageWithoutPageFactory();
//        sendText(loginPage.username, ConfigsReader.getProperties("username"));
//        sendText(loginPage.password, ConfigsReader.getProperties("password"));
//        clickButWaitForClickability(loginPage.loginBtn);


        // With PageFactory

//        var login = new _02_LoginPageWithPageFactory();
//        sendText(login.username2, ConfigsReader.getProperties("username"));
//        sendText(login.password2, ConfigsReader.getProperties("password"));
//        clickButWaitForClickability(login.loginBtn2);


        tearDown();
    }


}
