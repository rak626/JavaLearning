package Collections.ListInteface;

import java.util.ArrayList;
import java.util.List;

public class ListInterfaceDemo {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(23);
        arrayList.add(34);

        System.out.println(arrayList);

        System.out.println("element that got replaced:- " + arrayList.set(1, 100));

        System.out.println(arrayList);

        System.out.println(arrayList.lastIndexOf(1)); // return -1 if element not present

        List<Integer> integers = arrayList.subList(1, 5);
        System.out.println(integers);

        integers.set(0, 90);

        // position 1 in arraylist changes because sublist method does shallow copy
        System.out.println(arrayList);


        Integer[] array = arrayList.toArray(new Integer[0]);

        for(int arr : array){
            System.out.println(arr + ",");
        }
        System.out.println(array);


    }

}
