package lld.creational.CombinedFactoryDesignPattern;

public abstract class Restaurant {
    public Burger orderBurger() {
        Burger burger = createBurger();
//        burger.prepare();
        return burger;
    }
    public abstract Burger createBurger();
}
