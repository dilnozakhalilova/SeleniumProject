package Class8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _01_IteratorIntro {

    public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();// generic ArrayList
        doubleList.add(10.99);
        doubleList.add(5.56);
        doubleList.add(1.99);
        doubleList.add(107.87);
        doubleList.add(1103.00);
        doubleList.add(99.99);
        System.out.println("doubleList = " + doubleList);
        System.out.println("doubleList.get(2) = " + doubleList.get(2));

        System.out.println("====================For Loop=================================");
        for (int i = 0; i < doubleList.size(); i++) {
            System.out.println(doubleList.get(i));
            //  System.out.println(doubleList.get(i).doubleValue());
            //System.out.println(doubleList.get(i).intValue());
        }
        System.out.println("====================For Each Loop=============================");
        for (Double dList : doubleList) {// both double and Double(casted) are accepted
            System.out.println("dList = " + dList);

        }

        System.out.println("====================Iterator================================");
        Iterator<Double> doubleIterator = doubleList.iterator();// with iterator we prefer while()
        while(doubleIterator.hasNext()){
            System.out.println("Iterator example= "+ doubleIterator.next());
        }


    }


}
