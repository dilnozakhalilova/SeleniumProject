package Class8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _05_CarTestArrayList {
    public static void main(String[] args) {
        // Using ArrayList to store objects
        List<Car> cars= new ArrayList<>();

        cars.add(new Toyota("Gasoline"));
        cars.add(new Honda("Gasoline"));
        cars.add(new Tesla("Electric"));

        System.out.println("===========Enhanced Loop==============");

        for(Car car : cars){
            car.fueltype();
        }


        System.out.println("==========Iterator===================");
        Iterator<Car> iterator = cars.iterator();
        while(iterator.hasNext()){
            iterator.next().fueltype();
    }





    }



}
