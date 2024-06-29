package lld.creational.abstractfactorymethodpattern.products.chair;

// ModernChair implementation
public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Modern chair.");
    }
}
