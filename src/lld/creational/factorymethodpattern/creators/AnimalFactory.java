package lld.creational.factorymethodpattern.creators;

import lld.creational.factorymethodpattern.products.Animal;
import lld.creational.factorymethodpattern.products.Cow;
import lld.creational.factorymethodpattern.products.Dog;
import lld.creational.factorymethodpattern.products.Tiger;

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
