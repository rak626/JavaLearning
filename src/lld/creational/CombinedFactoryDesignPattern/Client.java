package lld.creational.CombinedFactoryDesignPattern;

public class Client {
    public static void main(String[] args) {
//        Restaurant restaurant = new Restaurant();
//        restaurant.orderBurger("BEEF");
//        restaurant.orderBurger("VEG");
//        restaurant.orderBurger("");
        Restaurant restaurant1 = null;
        restaurant1 = new BeefBurgerRestaurant();
        restaurant1.orderBurger().prepare();
        restaurant1 = new VegBurgerRestaurant();
        restaurant1.orderBurger().prepare();
    }
}
