package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.abstracto.Estado;

public class Pelear extends Estado {
    @Override
    public String activarEstado() {
        return "Listo para pelear";
    }

}//
