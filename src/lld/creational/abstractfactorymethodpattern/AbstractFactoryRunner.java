package lld.creational.abstractfactorymethodpattern;

import lld.creational.abstractfactorymethodpattern.creators.FurnitureFactory;
import lld.creational.abstractfactorymethodpattern.creators.ModernFurnitureFactory;
import lld.creational.abstractfactorymethodpattern.creators.VictorianFurnitureFactory;

public class AbstractFactoryRunner {
    public static void main(String[] args) {
        // modern
        FurnitureFactory modernFurniture = new ModernFurnitureFactory();
        Client client = new Client(modernFurniture);
        client.useFurniture();
        // gap
        System.out.println();
        // victorian
        client = new Client(new VictorianFurnitureFactory());
        client.useFurniture();
    }
}
