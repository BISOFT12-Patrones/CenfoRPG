package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Observador.Concreto;

import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Observador.Interfaces.Batalla;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Observador.Interfaces.Observador;

import java.util.ArrayList;
import java.util.List;

public class BatallaC implements Batalla {

    private List<Observador> observers = new ArrayList<Observador>();
    private String grupo;

    public BatallaC(String pGrupo){
        setGrupo(pGrupo);
    }


    @Override
    public void addObserver(Observador o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observador o) {

    }

    @Override
    public void notifyObservers() {
        for(Observador o : observers){
            o.irBatalla();
        }
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
