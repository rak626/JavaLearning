package lld.Structural.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        Burger burger = new ZingerBurger();
        System.out.println(burger.getDesc() + " costs " + burger.getCost());
        burger = new ExtraMayo(burger);
        System.out.println(burger.getDesc() + " costs " + burger.getCost());
        burger = new ExtraCheese(burger);
        System.out.println(burger.getDesc() + " costs " + burger.getCost());
        burger = new OnionBurger();
        System.out.println(burger.getDesc() + " costs " + burger.getCost());
        burger = new ExtraMayo(burger);
        System.out.println(burger.getDesc() + " costs " + burger.getCost());
        burger = new ExtraCheese(burger);
        System.out.println(burger.getDesc() + " costs " + burger.getCost());
    }
}
