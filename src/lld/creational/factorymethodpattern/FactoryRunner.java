package lld.creational.factorymethodpattern;

import lld.creational.factorymethodpattern.creators.AnimalFactory;
import lld.creational.factorymethodpattern.products.Animal;

public class FactoryRunner {
    public static void main(String[] args) {
//        this is tightly coupled
//        Animal animal = new Cow();
//        animal.makeSound();

//        make it loosely coupled
//        create a factory method , which will check for the business logic based on that it will give Animal object
        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal = animalFactory.createAnimalObject("Dog");
        animal.makeSound();
        animal = animalFactory.createAnimalObject("Tiger");
        animal.makeSound();
        animal = animalFactory.createAnimalObject("Cow");
        animal.makeSound();
    }
}
