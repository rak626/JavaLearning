package LLD.creational.AbstractFactoryDesignPattern;

import LLD.creational.AbstractFactoryDesignPattern.creators.FurnitureFactory;
import LLD.creational.AbstractFactoryDesignPattern.products.chair.Chair;
import LLD.creational.AbstractFactoryDesignPattern.products.sofa.Sofa;

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
