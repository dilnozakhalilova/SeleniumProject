package Class8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _02_IteratorDemo {
    public static void main(String[] args) {

        // Non- generic ArrayList=====> accepts any data types

        List randomList = new ArrayList<>();
        randomList.add("Apple");
        randomList.add("Orange");
        randomList.add(20);
        randomList.add(97.78);
        randomList.add(true);
        randomList.add(10==5);
        randomList.add('c');

        System.out.println("randomList = " + randomList);


        System.out.println("===========For Loop=============");
        for (int i = 0; i < randomList.size(); i++) {
            System.out.println("randomList = " + randomList.get(i));

        }
        System.out.println("===========For Each=============");
        for (Object randList : randomList) {
            System.out.println("randList = " + randList);
            
        }
        System.out.println("===========Iterator=============");

        Object var = randomList.listIterator();// Object is a parent class for generic arrayList
        Iterator randListIterator = randomList.iterator();
        while (randListIterator.hasNext()){
        System.out.println("randListIterator = " + randListIterator.next());


    }}









}
