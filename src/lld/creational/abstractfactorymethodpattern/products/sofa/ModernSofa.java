package lld.creational.abstractfactorymethodpattern.products.sofa;

// ModernSofa implementation
public class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Modern sofa.");
    }
}
