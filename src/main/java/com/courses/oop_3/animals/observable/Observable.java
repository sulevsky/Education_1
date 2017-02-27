package com.courses.oop_3.animals.observable;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers();
}
