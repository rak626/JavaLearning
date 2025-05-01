package LLD.creational.AbstractFactoryDesignPattern.practice.notificationSystem;

public class EmailNotification implements NotificationSenderFactory {

    @Override
    public MessageSender getSenderFromFactory() {
        return new EmailSender();
    }

    @Override
    public TemplateProvider getTemplateFromFactory() {
        return new EmailTemplate();
    }
}


