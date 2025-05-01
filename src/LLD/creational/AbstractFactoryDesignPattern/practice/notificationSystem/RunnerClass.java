package LLD.creational.AbstractFactoryDesignPattern.practice.notificationSystem;

public class RunnerClass {
    public static void main(String[] args) {
        NotificationSenderFactory sender = getFactory("sms");
        assert sender != null;
        MessageSender senderFromFactory = sender.getSenderFromFactory();
        TemplateProvider templateFromFactory = sender.getTemplateFromFactory();
        sendMessage(senderFromFactory, templateFromFactory);
    }

    private static NotificationSenderFactory getFactory(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Please provide correct String value");
        }
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            default -> null;
        };
    }

    private static void sendMessage(MessageSender sender, TemplateProvider template) {
        sender.getSender();
        template.getTemplate();
    }
}
