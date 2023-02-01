package Class20_POM.test;

import Class20_POM.pages._01_LoginPageWithoutPageFactory;
import utils.BaseClass;
import utils.ConfigsReader;

public class _01_LoginTest extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");


        // Without PageFactory

        var loginPage = new _01_LoginPageWithoutPageFactory();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        sendText(loginPage.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(loginPage.loginBtn);






        tearDown();
    }





}
