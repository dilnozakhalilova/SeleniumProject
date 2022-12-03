package Class3;

import java.util.ArrayList;
import java.util.List;

public class _05_JavaList {

    public static void main(String[] args) {
        _05_JavaList list = new _05_JavaList();
        List<String> listElements = list.findElements();
        for (int i = 0; i <listElements.size() ;i++) {
            String fruits = listElements.get(i);


        }

    }

    public List<String> findElements() {
        List<String> stringList = new ArrayList<>();

        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Banana");
        stringList.add("Grapes");
        stringList.add("Peach");
        return stringList;
    }


}