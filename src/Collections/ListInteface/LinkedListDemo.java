package Collections.ListInteface;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<Integer> lklist = new LinkedList<>();
        lklist.add(1);
        lklist.add(2);
        lklist.add(3);
        lklist.add(3);
        lklist.add(3);
        lklist.add(4);
        lklist.add(23);
        lklist.add(34);

        System.out.println(lklist);

        ListIterator<Integer> integerListIterator = lklist.listIterator();

        System.out.println(integerListIterator.hasPrevious());
        System.out.println(integerListIterator.next());
        System.out.println(integerListIterator.hasNext());
        System.out.println(integerListIterator.previous());
    }
}
