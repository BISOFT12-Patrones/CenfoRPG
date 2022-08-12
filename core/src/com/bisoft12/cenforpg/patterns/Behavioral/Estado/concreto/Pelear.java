package com.bisoft12.cenforpg.patterns.Behavioral.Estado.concreto;
import com.bisoft12.cenforpg.patterns.Behavioral.Estado.abstracto.Estado;
public class Pelear extends Estado {
    @Override
    public String activarEstado() {
        return "Listo para pelear";
    }

}//
