package LLD.ObserverPattern.ComplexExample.Observable;

import LLD.ObserverPattern.ComplexExample.Observer.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

