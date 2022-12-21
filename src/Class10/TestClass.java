package Class10;

import utils.BaseClass;

import static utils.BaseClass.*;

public class TestClass extends BaseClass {
    public static void main(String[] args) {
      setUp("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");      // <--- Lounch the browser

     System.out.println(   driver.getTitle() ); // Perfprm the action


      tearDown();







    }
}
