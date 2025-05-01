package LLD.creational.AbstractFactoryDesignPattern.practice.notificationSystem;

public class SmsNotification implements NotificationSenderFactory{

    @Override
    public MessageSender getSenderFromFactory() {
        return new SmsSender();
    }

    @Override
    public TemplateProvider getTemplateFromFactory() {
        return new SmsTemplate();
    }
}


