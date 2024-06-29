package lld.creational.abstractfactorymethodpattern.products.sofa;


// VictorianSofa implementation
public class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Victorian sofa.");
    }
}
