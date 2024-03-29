package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.objeto;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.abstracto.Estado;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto.Pelear;

public class Casa {
    private Estado objEstadoCasa;
    public Casa() {
        setEstado(new Pelear());
    }
    public void setEstado( Estado objEstadoCasa ) {
        this.objEstadoCasa = objEstadoCasa;
    }
    public String activarEstado() {
        return this.objEstadoCasa.activarEstado();
    }

}//
