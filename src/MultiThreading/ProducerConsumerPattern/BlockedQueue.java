package MultiThreading.ProducerConsumerPattern;

import java.util.LinkedList;
import java.util.Queue;

public class BlockedQueue {
    private Queue<Integer> q;
    private int capacity;

    public BlockedQueue(int capacity) {
        q = new LinkedList<>();
        this.capacity = capacity;
    }

    public int add(int item) {
        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            boolean offer = q.offer(item);
            q.notifyAll();
            return offer ? item : 0;
        }
    }

    public int remove() {
        synchronized (q) {
            while (q.isEmpty()) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int item = q.poll();
            q.notifyAll();
            return item;
        }
    }
}
