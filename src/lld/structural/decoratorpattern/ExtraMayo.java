package lld.structural.decoratorpattern;

public class ExtraMayo extends BurgerDecorator {

    private Burger burger;

    public ExtraMayo(Burger burger) {
        this.burger = burger;
    }

    @Override
    public String getDesc() {
        return burger.getDesc() + " extra mayo";
    }

    @Override
    public Double getCost() {
        return this.burger.getCost() + 20;
    }
}
