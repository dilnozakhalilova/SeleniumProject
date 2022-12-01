package Class8;


import java.util.Arrays;
import java.util.Iterator;

public class CarsTest {
    public static void main(String[] args) {
        //Regular way of storing objects in an array
        Cars[] carsArray =
                {new Toyota("Gasoline"),
                        new Honda("Gasoline"),
                        new Tesla("Electric")};

        System.out.println("==========Enhanced Loop==============");
        for(Cars car : carsArray){
            car.fueltype();
        }

        System.out.println("==========For loop==============");
        for (int i = 0; i < carsArray.length; i++) {
            carsArray[i].fueltype();
        }

        System.out.println("==========Iterator==============");
        Iterator<Cars> iterator = Arrays.stream(carsArray).iterator();
        while(iterator.hasNext()){
            iterator.next().fueltype();
        }

    }

}
