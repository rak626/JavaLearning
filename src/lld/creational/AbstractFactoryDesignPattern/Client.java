package lld.creational.AbstractFactoryDesignPattern;

import lld.creational.AbstractFactoryDesignPattern.creators.FurnitureFactory;
import lld.creational.AbstractFactoryDesignPattern.products.chair.Chair;
import lld.creational.AbstractFactoryDesignPattern.products.sofa.Sofa;

public class Client {
    private Chair chair;
    private Sofa sofa;

    public Client(FurnitureFactory factory) {
        chair = factory.createChair();
        sofa = factory.createSofa();
    }

    public void useFurniture() {
        chair.sitOn();
        sofa.lieOn();
    }
}
