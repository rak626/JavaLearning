package lld.creational.AbstractFactoryDesignPattern.creators;

import lld.creational.AbstractFactoryDesignPattern.products.chair.Chair;
import lld.creational.AbstractFactoryDesignPattern.products.chair.ModernChair;
import lld.creational.AbstractFactoryDesignPattern.products.sofa.ModernSofa;
import lld.creational.AbstractFactoryDesignPattern.products.sofa.Sofa;

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
