package lld.creational.factorymethodpattern.products;

public class Cow implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cow is Mowing ..");
    }
}
