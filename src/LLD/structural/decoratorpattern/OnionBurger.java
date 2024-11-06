package LLD.structural.decoratorpattern;

public class OnionBurger extends Burger {
    @Override
    public String getDesc() {
        return "Onion Burger";
    }

    @Override
    public Double getCost() {
        return 60.0;
    }
}
