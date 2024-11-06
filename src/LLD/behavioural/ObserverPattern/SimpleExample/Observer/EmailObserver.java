package LLD.behavioural.ObserverPattern.SimpleExample.Observer;

public class EmailObserver implements NotificationObserver {

    private final String email;
    private final String msg;

    public EmailObserver(String email, String msg) {
        this.email = email;
        this.msg = msg;
    }

    @Override
    public void update() {
        System.out.println("Email sent to :" + this.email + " with message: " + this.msg);
    }
}
