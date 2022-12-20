package Class12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utils.BaseClass.*;


//import static utils.BaseClass.*;
//button#showSmallModal
// //button[@class='mr-4 mt-2 btn btn-primary']
// switchTo() will not work here because it is not a Java script type


// if you cannot click and inspect the button it is java script based
public class _02_ModalAlert {
    public static void main(String[] args) throws InterruptedException {
    setUp();//url=https://demoqa.com/modal-dialogs

        WebElement modalAlert = driver.findElement(By.id("showSmallModal"));//Finding webElement for modalAlert alert type(HTML based alert). You can click
        modalAlert.click();                     // click to launch it
        System.out.println(modalAlert.getText());//Retreaving the text of Modal dialog (WebElement itself)

        String modalTitleText = driver.findElement(By.xpath("//div[@class='modal-title h4']")).getText();
        System.out.println("modalTitleText = " + modalTitleText);

        System.out.println("Modal body: "+driver.findElement(By.xpath("//div[@class='modal-body']")).getText());



        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Close']")).click();    // I am closing the modal by clicking "Close Button"


        tearDown();
    }
}
