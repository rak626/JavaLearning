package lld.structural.decoratorpattern;

public class ZingerBurger extends Burger {
    @Override
    public String getDesc() {
        return "Zinger Burger ";
    }

    @Override
    public Double getCost() {
        return 100.0;
    }
}
