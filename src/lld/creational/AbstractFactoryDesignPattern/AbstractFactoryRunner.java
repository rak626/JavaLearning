package lld.creational.AbstractFactoryDesignPattern;

import lld.creational.AbstractFactoryDesignPattern.creators.FurnitureFactory;
import lld.creational.AbstractFactoryDesignPattern.creators.ModernFurnitureFactory;
import lld.creational.AbstractFactoryDesignPattern.creators.VictorianFurnitureFactory;

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
