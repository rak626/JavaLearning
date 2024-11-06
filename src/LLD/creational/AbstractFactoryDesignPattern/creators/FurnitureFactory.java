package LLD.creational.AbstractFactoryDesignPattern.creators;

import LLD.creational.AbstractFactoryDesignPattern.products.chair.Chair;
import LLD.creational.AbstractFactoryDesignPattern.products.sofa.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

