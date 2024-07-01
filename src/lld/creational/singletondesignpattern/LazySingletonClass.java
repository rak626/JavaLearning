package lld.creational.singletondesignpattern;

public class LazySingletonClass {
    private static LazySingletonClass object;

    private LazySingletonClass() {
    }

    public static LazySingletonClass getInstance() {
        if (object == null) {
            object = new LazySingletonClass();
        }
        return object;
    }
}

/*
 * Why it is called Lazy ?
 * as we know static variables are loaded when program start,
 * so that means initially object value is null,
 * and we are not creating any object until anyone ask for it
 * this behaviour is called Lazy initialization
 * */

/*
 * Disadvantages :-
 * It will fail if we try to create object of it in two different thread
 * then for both thread two different object will create
 * */