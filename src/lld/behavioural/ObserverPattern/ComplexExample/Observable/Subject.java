package lld.behavioural.ObserverPattern.ComplexExample.Observable;

import lld.behavioural.ObserverPattern.ComplexExample.Observer.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

