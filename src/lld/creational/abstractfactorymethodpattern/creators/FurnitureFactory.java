package lld.creational.abstractfactorymethodpattern.creators;

import lld.creational.abstractfactorymethodpattern.products.chair.Chair;
import lld.creational.abstractfactorymethodpattern.products.sofa.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

