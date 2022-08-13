package com.bisoft12.cenforpg.patterns.Behavioral.Memento;

public class CareTaker {
    private Memento memento;
    // ---------------------------
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
    // ---------------------------
    public Memento getMemento() {
        return this.memento;
    }

}//
