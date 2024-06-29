package lld.creational.abstractfactorymethodpattern;

import lld.creational.abstractfactorymethodpattern.creators.FurnitureFactory;
import lld.creational.abstractfactorymethodpattern.products.chair.Chair;
import lld.creational.abstractfactorymethodpattern.products.sofa.Sofa;

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
