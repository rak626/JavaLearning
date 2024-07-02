package lld.creational.FactoryDesignPattern.products;

public class Tiger implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Tiger is roaring..");
    }
}
