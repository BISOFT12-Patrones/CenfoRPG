package com.bisoft12.cenforpg.patterns.Comportamiento.Main;

import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Observador.Concreto.BatallaC;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Observador.Concreto.ObservadorC;

import java.util.HashMap;

public class GestorObservador {

    private static HashMap<String, BatallaC> listaBatalla;
    private Gestor_Memento gestor_memento = new Gestor_Memento();

    public GestorObservador() {
        listaBatalla = new HashMap <String, BatallaC>();
    }

    public void nuevaBatalla(String pKey) {
        listaBatalla.put(pKey, new BatallaC(pKey));
    }

    public void NuevoObservador(String pObservador, String pProducto) {
        listaBatalla.get(pProducto).addObserver(new ObservadorC(pObservador));
    }

    public void irBatalla(String pObservador){
        gestor_memento.nuevoPersonaje();
        listaBatalla.get(pObservador).notifyObservers();
    }

    public void limpiaBatallas(){
        listaBatalla.clear();
    }
}
