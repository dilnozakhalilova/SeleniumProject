package Class12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _08_UploadFiles {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/upload");
        /**
         * How doe we upload files using selenium?
         * 1. specify file location on your computer -- get full path of the file you are about to upload
         * 2. Locate web element for "Choose File" button, and using sendKeys() method, send the location/ full path of the file
         * 3. Locate upload button element and click it to upload your file
         *
         * this way we bypass the window popup, which is not supported by Selenium. (just like we did with Authentication alert)
         */


        //   Step 1. Find the file path in your local maschine and store it in a String

        String filePath = "C:\\Users\\Dilnoza\\Desktop\\text picture.png";

        // Step 2. Locate webelement for the "Choose File" button( Button that triggers Window popup  for file upload)
        driver.findElement(By.id("file-upload")).sendKeys(filePath);


        // Step 3. Locate webelement for "Submit" or "Upload" button and click on it, to upload your file
        driver.findElement(By.id("file-submit")).click();

        // Now lets verify is file is uploaded or not

        WebElement fileUploadConformation = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        if (fileUploadConformation.isDisplayed())
            System.out.println("File is uploaded successfully.");
        else System.out.println("File is NOT uploaded.");


        tearDown();
    }


}
