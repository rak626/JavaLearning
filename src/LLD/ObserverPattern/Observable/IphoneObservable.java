package LLD.ObserverPattern.Observable;

import LLD.ObserverPattern.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable {

    private final List<NotificationObserver> observers = new ArrayList<>();
    private int stock = 0;

    @Override
    public void registerObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (NotificationObserver observer : observers){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        if(stock == 0){
            this.notifyObservers();
        }
        stock += stockCount;
    }

    @Override
    public int getStockCount() {
        return this.stock;
    }
}
