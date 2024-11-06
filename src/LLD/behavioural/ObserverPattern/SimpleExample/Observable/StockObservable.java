package LLD.behavioural.ObserverPattern.SimpleExample.Observable;

import LLD.behavioural.ObserverPattern.SimpleExample.Observer.NotificationObserver;

public interface StockObservable {

    void registerObserver(NotificationObserver observer);

    void removeObserver(NotificationObserver observer);

    void notifyObservers();

    void setStockCount(int stockCount);

    int getStockCount();
}
