package Class10;

import utils.BaseClass;
import utils.BaseClass.setUp;
import utils.BaseClass.tearDown;

import static utils.BaseClass.tearDown;

public class TestClass extends BaseClass{
    public static void main(String[] args) {
        setUp();

        System.out.println(driver.getTitle());


        tearDown();

    }

}
