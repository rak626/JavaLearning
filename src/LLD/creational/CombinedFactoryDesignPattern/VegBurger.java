package LLD.creational.CombinedFactoryDesignPattern;

public class VegBurger extends Burger {
    private boolean combos;

    public VegBurger() {
    }

//    public VegBurger(boolean combos, int productId, String addons) {
//        this.combos = combos;
//        this.productId = productId;
//        this.addons = addons;
//    }


    @Override
    public void prepare() {
        System.out.println("Veg burger preparing ....");
    }
}
