package Class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class MoreCommandsDemo {
    private static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
    private static String user= "Tester";
    private static String pwd ="test";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement userName = driver.findElement(By.xpath("//input[contains(@id,'username')]"));
        Thread.sleep(2000);
        userName.sendKeys("QAEngineer");

        Thread.sleep(2000);
        userName.clear();

        Thread.sleep(2000);
        userName.sendKeys(user);


        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys(pwd);

        Thread.sleep(1000);

        WebElement logIn = driver.findElement(By.cssSelector("input.button"));
        logIn.click(); //Almost same as submit----> does not wait for the page to fully load
        //logIn.submit();//------> waits until page is fully load: submit is preffrered

        // once loged into the dashboard, verify it using an element dro the dashboard page

        WebElement webOrdersLogo = driver.findElement(By.xpath("//ul[@id='ctl00_menu']/preceding-sibling::h1"));

        boolean logoDisplayed = webOrdersLogo.isDisplayed();

        if(logoDisplayed) {
            System.out.println("Logo is displayed. Test case passed");
        }else{
            System.out.println("Logo is not displayed. Test case failed");
        }
        // Identify logged in user on the dashboard page

        WebElement loggedinUser = driver.findElement(By.cssSelector("div.login_info"));

        String loggedinUserText = loggedinUser.getText();
        String expectedLoggedinUserText = "Welcome, Tester! | Logout 123";


        if(loggedinUserText.contains(user)){
            System.out.println("Authorized user is able to login successfully. Test passed");
        }else{
            System.out.println("Authorized user is not able to login successfully. Test failed");
        }

        System.out.println("loggedinUserText = " + loggedinUserText);



        Thread.sleep(2000);
        driver.close();





    }


}