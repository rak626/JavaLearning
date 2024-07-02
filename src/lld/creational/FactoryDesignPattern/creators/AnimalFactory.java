package lld.creational.FactoryDesignPattern.creators;

import lld.creational.FactoryDesignPattern.products.Animal;
import lld.creational.FactoryDesignPattern.products.Cow;
import lld.creational.FactoryDesignPattern.products.Dog;
import lld.creational.FactoryDesignPattern.products.Tiger;

public class AnimalFactory {
    public Animal createAnimalObject(String className) {
        return switch (className) {
            case "Dog" -> new Dog();
            case "Cow" -> new Cow();
            case "Tiger" -> new Tiger();
            default -> null;
        };
    }
}
