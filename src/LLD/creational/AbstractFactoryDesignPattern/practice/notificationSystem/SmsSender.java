package LLD.creational.AbstractFactoryDesignPattern.practice.notificationSystem;

public class SmsSender implements MessageSender{

    @Override
    public void getSender() {
        System.out.println("This is Sms Sender ...");
    }
}


