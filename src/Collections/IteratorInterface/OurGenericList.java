package Collections.IteratorInterface;

import java.util.Iterator;

public class OurGenericList<T> implements Iterable<T> {

    private T[] items;
    private int size;

    public OurGenericList(){
        size = 0;
        items = (T[])new Object[100];
    }

    public void add(T item){
        items[size++] = item;
    }
    public  T getItemAtIndex(int index){
        return items[index];
    }


    @Override
    public Iterator<T> iterator() {
        return new OurGenericListIterator<>(this);
    }

    private class OurGenericListIterator<T> implements Iterator<T>{

        private OurGenericList<T> list;
        private int index;
        public OurGenericListIterator(OurGenericList<T> list){
            this.list = list;
            this.index = 0;
        }
        @Override
        public boolean hasNext() {
            System.out.println("has next called");
            return index < list.size;
        }

        @Override
        public T next() {
            System.out.println("next called");
            return list.items[index++];
        }
    }
}
