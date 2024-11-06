package LLD.creational.SingletonDesignPattern;

public class ModifiedDoubleLockSingletonClass {
    private static volatile ModifiedDoubleLockSingletonClass object;

    private ModifiedDoubleLockSingletonClass() {
    }

    public static ModifiedDoubleLockSingletonClass getInstance() {
        if (object == null) {
            synchronized (ModifiedDoubleLockSingletonClass.class) {
                if (object == null) {
                    object = new ModifiedDoubleLockSingletonClass();
                }
            }
        }
        return object;
    }
}

/*
 * Advantages :-
 * It will resolve the memory issue described in Double lock
 * volatile keyword will look after the memory issue.
 * it will force that creation and read of that object should be done from memory only , no cache involvement
 * */

/*
 * Disadvantages :-
 * still uses synchronized. it is still slow
 * */