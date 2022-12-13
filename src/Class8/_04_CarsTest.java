package Class8;


import java.util.Arrays;
import java.util.Iterator;

public class _04_CarsTest {
    public static void main(String[] args) {
        //Regular way of storing objects in an array
        Car[] carsArray =
                {new Toyota("Gasoline"),
                        new Honda("Gasoline"),
                        new Tesla("Electric")};

        System.out.println("==========Enhanced Loop==============");
        for(Car car : carsArray){
            car.fueltype();
        }

        System.out.println("==========For loop==============");
        for (int i = 0; i < carsArray.length; i++) {
            carsArray[i].fueltype();
        }

        System.out.println("==========Iterator==============");
        Iterator<Car> iterator = Arrays.stream(carsArray).iterator();
        while(iterator.hasNext()){
            iterator.next().fueltype();
        }

    }

}
