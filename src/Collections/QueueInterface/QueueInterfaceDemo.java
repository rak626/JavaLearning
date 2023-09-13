package Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueInterfaceDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        // add method throws exception, but offer method does not
        queue.add(1);
        queue.offer(2);
        // offer return boolean
        boolean offered = queue.offer(3);

        System.out.println(offered);

        System.out.println(queue);
        // remove method throws exception, but poll method does not
        queue.remove();
        // return removed element
        queue.poll();

        System.out.println(queue);

        queue.remove();
        // no such element exception thrown if queue is empty
//        queue.remove();
        System.out.println(queue);

        // element () throws exception but peek() throws null if no element present
//        System.out.println(queue.element());
        System.out.println(queue.peek());
    }
}
