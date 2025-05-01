package LLD.creational.AbstractFactoryDesignPattern.practice.notificationSystem;

public class EmailSender implements MessageSender{

    @Override
    public void getSender() {
        System.out.println("This is Email Sender ...");
    }
}

