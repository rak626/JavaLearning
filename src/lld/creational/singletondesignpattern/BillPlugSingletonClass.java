package lld.creational.singletondesignpattern;

public class BillPlugSingletonClass {

    private BillPlugSingletonClass() {
    }

    private static final class ObjectHolder {
        private static final BillPlugSingletonClass object = new BillPlugSingletonClass();
    }

    public static BillPlugSingletonClass getInstance() {
        return ObjectHolder.object;
    }
}

/*
 * Advantages :-
 * uses same eager way, but introduce inner class or nested class concept
 * inner classes will load only when it is invoked.
 * this way it resolved the eager singleton class solution
 */