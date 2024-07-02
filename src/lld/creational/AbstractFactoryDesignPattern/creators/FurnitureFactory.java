package lld.creational.AbstractFactoryDesignPattern.creators;

import lld.creational.AbstractFactoryDesignPattern.products.chair.Chair;
import lld.creational.AbstractFactoryDesignPattern.products.sofa.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

