package lld.creational.abstractfactorymethodpattern.creators;

import lld.creational.abstractfactorymethodpattern.products.chair.Chair;
import lld.creational.abstractfactorymethodpattern.products.chair.VictorianChair;
import lld.creational.abstractfactorymethodpattern.products.sofa.Sofa;
import lld.creational.abstractfactorymethodpattern.products.sofa.VictorianSofa;

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
