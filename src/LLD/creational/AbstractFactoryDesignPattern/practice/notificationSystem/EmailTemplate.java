package LLD.creational.AbstractFactoryDesignPattern.practice.notificationSystem;

public class EmailTemplate implements TemplateProvider{

    @Override
    public void getTemplate() {
        System.out.println("This is Email Template ...");
    }
}
