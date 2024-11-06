package LLD.behavioural.ObserverPattern.ComplexExample.Observable;

import LLD.behavioural.ObserverPattern.ComplexExample.Observer.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

