package lld.creational.abstractfactorymethodpattern.creators;

import lld.creational.abstractfactorymethodpattern.products.chair.Chair;
import lld.creational.abstractfactorymethodpattern.products.chair.ModernChair;
import lld.creational.abstractfactorymethodpattern.products.sofa.ModernSofa;
import lld.creational.abstractfactorymethodpattern.products.sofa.Sofa;

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
