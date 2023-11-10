package MultiThreading;

public class ThreadDemo {
    public static void main(String[] args) {

        System.out.println("main starting ..");


        Thread1 thread1 = new Thread1("my first thread");
//        thread1.setDaemon(true);
        thread1.start();

        /*try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("main ending ..");
    }
}
