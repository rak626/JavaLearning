package lld.creational.singletondesignpattern;

public class SingletonRunner {
    public static void main(String[] args) {
        EagerSingletonClass eagerSingletonClass = EagerSingletonClass.getInstance();
        LazySingletonClass lazySingletonClass = LazySingletonClass.getInstance();
        SynchronizedSingletonClass synchronizedSingletonClass = SynchronizedSingletonClass.getInstance();
        DoubleLockSingletonClass doubleLockSingletonClass = DoubleLockSingletonClass.getInstance();
        ModifiedDoubleLockSingletonClass modifiedDoubleLockSingletonClass = ModifiedDoubleLockSingletonClass.getInstance();
        BillPlugSingletonClass billPlugSingletonClass = BillPlugSingletonClass.getInstance();
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
    }
}
