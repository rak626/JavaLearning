package Collections.IteratorInterface;

public class IteratorInterfaceDemo {
    public static void main(String[] args) {
        OurGenericList<Integer> list = new OurGenericList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for(int item : list){
            System.out.println(item);
        }

    }

}
