package LLD.ObserverPattern.Observer;

public class MobileObserver implements NotificationObserver{

    private final String mobileNo;
    private final String msg;

    public MobileObserver(String mobileNo, String msg) {
        this.mobileNo = mobileNo;
        this.msg = msg;
    }

    @Override
    public void update() {
        System.out.println("Notification send to Mobile No : " + this.mobileNo + "  message is : " + this.msg);
    }
}
