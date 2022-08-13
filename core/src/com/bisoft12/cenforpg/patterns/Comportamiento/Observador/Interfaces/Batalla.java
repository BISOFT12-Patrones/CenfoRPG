package com.bisoft12.cenforpg.patterns.Comportamiento.Observador.Interfaces;

public interface Batalla {
    void addObserver(Observador o);
    void removeObserver(Observador o);
    void notifyObservers();
}
