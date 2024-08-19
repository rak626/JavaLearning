package MultiThreading.ProducerConsumerPattern;

public class MainRunner {
    public static void main(String[] args) {
        BlockedQueue bq = new BlockedQueue(5);
        new Thread(() -> {
            int counter = 0;
            while(++counter < 10)
                System.out.println( " queue added from thread 1 : Counter  " + counter + " : " + bq.add(counter));
            System.out.println("+++++++++++++++++++++++++++++++++");
        }, "addar 1").start();
        new Thread(() -> {
            int counter = 0;
            while(++counter < 10)
                System.out.println( " queue removed from thread 2 : Counter  " + counter + " : " + bq.remove());
            System.out.println("--------------------------------------");
        }, "addar 2").start();
        new Thread(() -> {
            int counter = 0;
            while(++counter < 10)
                System.out.println( " queue added from thread 3 : Counter  " + counter + " : " + bq.add(counter));
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }, "addar 3").start();
        new Thread(() -> {
            int counter = 0;
            while(++counter < 10)
                System.out.println( " queue removed from thread 4 : Counter  " + counter + " : " + bq.remove());
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        }, "addar 4").start();
    }
}
