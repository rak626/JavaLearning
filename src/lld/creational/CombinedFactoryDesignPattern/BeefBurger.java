package lld.creational.CombinedFactoryDesignPattern;

public class BeefBurger extends Burger {
    private boolean angus;

    public void prepare() {
        System.out.println("Beef burger preparing ....");
    }
}
