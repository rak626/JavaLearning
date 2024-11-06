package LLD.creational.CombinedFactoryDesignPattern;

public class VegBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new VegBurger();
    }
}
