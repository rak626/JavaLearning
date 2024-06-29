package lld.Structural.DecoratorPattern;

// is-A relationship with Burger
public class ExtraCheese extends BurgerDecorator{

    // has-A relationship / compositor with Burger
    private Burger burger;

    public ExtraCheese(Burger burger){
        this.burger = burger;
    }
    @Override
    public String getDesc() {
        return this.burger.getDesc() + " with extra cheese ";
    }

    @Override
    public Double getCost() {
        return this.burger.getCost() + 10.0;
    }
}
