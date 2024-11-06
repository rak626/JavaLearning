package LLD.creational.AbstractFactoryDesignPattern;

import LLD.creational.AbstractFactoryDesignPattern.creators.FurnitureFactory;
import LLD.creational.AbstractFactoryDesignPattern.creators.ModernFurnitureFactory;
import LLD.creational.AbstractFactoryDesignPattern.creators.VictorianFurnitureFactory;

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
