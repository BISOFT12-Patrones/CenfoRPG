package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.auxiliar.Snapshoot;

public class Originator {
    private Snapshoot _Estado;
    public Originator() {
        _Estado = new Snapshoot();
    }

    public String nuevoEstado(int level,int experience) {
        this._Estado.nuevaInstantanea(level,experience);
        return "Originador> nuevo estado [Nivel: "+level+" Experiencia: "+experience+"]";
    }

    public String obtenerEstado(int pIdx) {
        return this._Estado.obtenerInstantanea().get(pIdx);
    }

    public String obtenerEstado() {
        return "Originador> estado actual [" +
                this._Estado.obtenerInstantanea().get(0) + " " +
                this._Estado.obtenerInstantanea().get(1) + "]" ;
    }

/*==========================================================================
 *						 Seccion donde usamos el memento.
 ==========================================================================*/

    public void restaurarMemento(Memento m) {
        this._Estado.nuevaInstantanea (m.obtenerMemento(0), m.obtenerMemento(1));
    }

    public Memento crearMemento() {
        return new Memento(this._Estado.obtenerInstantanea().get(0), this._Estado.obtenerInstantanea().get(1));
    }




}//
