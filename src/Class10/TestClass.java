package Class10;

import utils.BaseClass;

import static utils.BaseClass.*;

public class TestClass extends BaseClass {
    public static void main(String[] args) {
      setUp();      // <--- Lounch the browser

     System.out.println(   driver.getTitle() ); // Perfprm the action


      tearDown();







    }
}
