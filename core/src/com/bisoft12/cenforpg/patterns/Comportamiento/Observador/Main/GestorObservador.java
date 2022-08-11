package com.bisoft12.cenforpg.patterns.Comportamiento.Observador.Main;

import com.bisoft12.cenforpg.patterns.Comportamiento.Observador.Concreto.BatallaC;
import com.bisoft12.cenforpg.patterns.Comportamiento.Observador.Concreto.ObservadorC;

import java.util.HashMap;

public class GestorObservador {

    private static HashMap<String, BatallaC> listaBatalla;

    public GestorObservador() {
        listaBatalla = new HashMap <String, BatallaC>();
    }

    public void nuevaBatalla(String pKey) {
        listaBatalla.put(pKey, new BatallaC(pKey));
    }

    public void NuevoObservador(String pObservador, String pProducto) {
        listaBatalla.get(pProducto).addObserver(new ObservadorC(pObservador));
    }

    public void limpiaBatallas(){
        listaBatalla.clear();
    }
}
