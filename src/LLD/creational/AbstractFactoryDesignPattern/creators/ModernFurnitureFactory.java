package LLD.creational.AbstractFactoryDesignPattern.creators;

import LLD.creational.AbstractFactoryDesignPattern.products.chair.Chair;
import LLD.creational.AbstractFactoryDesignPattern.products.chair.ModernChair;
import LLD.creational.AbstractFactoryDesignPattern.products.sofa.ModernSofa;
import LLD.creational.AbstractFactoryDesignPattern.products.sofa.Sofa;

// ModernFurnitureFactory implementation
public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
