package lld.creational.FactoryDesignPattern.products;

public class Cow implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cow is Mowing ..");
    }
}
