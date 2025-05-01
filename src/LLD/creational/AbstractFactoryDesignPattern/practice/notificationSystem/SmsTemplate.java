package LLD.creational.AbstractFactoryDesignPattern.practice.notificationSystem;

public class SmsTemplate implements TemplateProvider {

    @Override
    public void getTemplate() {
        System.out.println("This is Sms Template ...");
    }
}


