package lld.creational.SingletonDesignPattern;

public class SynchronizedSingletonClass {

    private static SynchronizedSingletonClass object;

    private SynchronizedSingletonClass() {
    }

    synchronized public static SynchronizedSingletonClass getInstance() {
        if (object == null) {
            object = new SynchronizedSingletonClass();
        }
        return object;
    }
}

/*
 * Advantages :-
 * It will be thread safe
 * */

/*
 * Disadvantages :-
 * as this method is synchronized then lock and unlock mechanism will be there
 * if there is multiple sequential call happen then this process will be very slow
 * that's why we should not use this way
 * */