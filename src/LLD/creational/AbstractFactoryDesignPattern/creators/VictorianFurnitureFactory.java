package LLD.creational.AbstractFactoryDesignPattern.creators;

import LLD.creational.AbstractFactoryDesignPattern.products.chair.Chair;
import LLD.creational.AbstractFactoryDesignPattern.products.chair.VictorianChair;
import LLD.creational.AbstractFactoryDesignPattern.products.sofa.Sofa;
import LLD.creational.AbstractFactoryDesignPattern.products.sofa.VictorianSofa;

// VictorianFurnitureFactory implementation
public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
