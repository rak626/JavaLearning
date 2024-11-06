package LLD.creational.FactoryDesignPattern.creators;

import LLD.creational.FactoryDesignPattern.products.Animal;
import LLD.creational.FactoryDesignPattern.products.Cow;
import LLD.creational.FactoryDesignPattern.products.Dog;
import LLD.creational.FactoryDesignPattern.products.Tiger;

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
