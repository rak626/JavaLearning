package LLD.creational.AbstractFactoryDesignPattern.practice.notificationSystem;

public interface NotificationSenderFactory {
    MessageSender getSenderFromFactory();

    TemplateProvider getTemplateFromFactory();
}


