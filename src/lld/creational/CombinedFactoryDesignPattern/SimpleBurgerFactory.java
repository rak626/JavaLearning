package lld.creational.CombinedFactoryDesignPattern;

public class SimpleBurgerFactory {
    public Burger createBurger(String request) {
        Burger burger = null;
        if ("BEEF".equals(request)) {
            burger = new BeefBurger();
        } else if ("VEG".equals(request)) {
            burger = new VegBurger();
        }
        return burger;
    }
}
