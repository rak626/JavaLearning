package lld.behavioural.ObserverPattern.SimpleExample;

import lld.behavioural.ObserverPattern.SimpleExample.Observable.IphoneObservable;
import lld.behavioural.ObserverPattern.SimpleExample.Observable.StockObservable;
import lld.behavioural.ObserverPattern.SimpleExample.Observer.EmailObserver;
import lld.behavioural.ObserverPattern.SimpleExample.Observer.MobileObserver;
import lld.behavioural.ObserverPattern.SimpleExample.Observer.NotificationObserver;

public class ObserverPatternRunner {
    public static void main(String[] args) {
        NotificationObserver observer1 = new EmailObserver("abc.gmail.com", " Email notification sent to gmail...");
        NotificationObserver observer2 = new EmailObserver("xyz.rediffmail.com", " Email notification sent to rediffmail...");
        NotificationObserver observer3 = new MobileObserver("7001074104", " Mobile notification sent to rediffmail...");

        StockObservable stockObservable = new IphoneObservable();
        stockObservable.registerObserver(observer1);
        stockObservable.registerObserver(observer2);
        stockObservable.registerObserver(observer3);

        stockObservable.setStockCount(10);
        stockObservable.setStockCount(-10);
        System.out.println();
        stockObservable.setStockCount(20);
        System.out.println();
        stockObservable.removeObserver(observer2);

        stockObservable.setStockCount(-20);
        System.out.println();
        stockObservable.setStockCount(202);
        System.out.println();

    }
}
