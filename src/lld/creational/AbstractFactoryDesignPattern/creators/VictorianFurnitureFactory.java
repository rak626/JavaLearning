package lld.creational.AbstractFactoryDesignPattern.creators;

import lld.creational.AbstractFactoryDesignPattern.products.chair.Chair;
import lld.creational.AbstractFactoryDesignPattern.products.chair.VictorianChair;
import lld.creational.AbstractFactoryDesignPattern.products.sofa.Sofa;
import lld.creational.AbstractFactoryDesignPattern.products.sofa.VictorianSofa;

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
