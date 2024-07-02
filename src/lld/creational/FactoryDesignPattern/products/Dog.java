package lld.creational.FactoryDesignPattern.products;

public class Dog implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Dog is Barking ..");
    }
}
