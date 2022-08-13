package com.bisoft12.cenforpg.patterns.Behavioral.Estado.concreto;
import com.bisoft12.cenforpg.patterns.Behavioral.Estado.abstracto.Estado;

public class Recuperar extends Estado {
    @Override
    public String activarEstado() {
        return "Recuperando vidas. \n" + detenerJuego();
    }
    private String detenerJuego() {
        return ("Necesitas recuperarte antes de pelear");
    }

}//
