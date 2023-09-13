package Collections.SetInterface;

import Collections.QueueInterface.StudentMarks;

import java.util.*;

public class SetInterfaceDemo {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(5);
        set1.add(2);
        set1.add(4);
        set1.add(2);
        set1.add(4);

        System.out.println(set1);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(7);
        set2.add(2);
        set2.add(4);
        set2.add(2);
        set2.add(4);
        System.out.println(set2);

//        Integer[] array = set1.toArray(new Integer[0]);
//        System.out.println(array);
//        for(int a : array) System.out.println(a);

        System.out.println(set2.containsAll(set1));

//        set1.addAll(set2);
//        set1.retainAll(set2);
        set1.removeAll(set2);
        System.out.println(set1);

        System.out.println("------ student marks class set---------");

        Set<StudentMarks> studentMarksSet = new HashSet<>();
        studentMarksSet.add(new StudentMarks(45, 40, 38));
        studentMarksSet.add(new StudentMarks(40, 27, 80));
        studentMarksSet.add(new StudentMarks(78, 65, 98));
        studentMarksSet.add(new StudentMarks(77, 69, 91));
        studentMarksSet.add(new StudentMarks(77, 40, 75));
        studentMarksSet.add(new StudentMarks(100, 95, 97));

        System.out.println(studentMarksSet.contains(new StudentMarks(100, 95, 97)));


        System.out.println("--------Sorted Set / navigable set----------");

        NavigableSet<Integer> set3 = new TreeSet<>();

        set3.add(1);
        set3.add(7);
        set3.add(2);
        set3.add(4);
        set3.add(2);
        set3.add(4);

        System.out.println(set3);
        //floor and ceiling throws exceptions
        System.out.println(set3.floor(5));
        System.out.println(set3.ceiling(5));

        //higher and lower doesn't throw exception, it returns null as a result
        System.out.println(set3.higher(5));
        System.out.println(set3.lower(5));


        System.out.println(set3.last());

    }
}
