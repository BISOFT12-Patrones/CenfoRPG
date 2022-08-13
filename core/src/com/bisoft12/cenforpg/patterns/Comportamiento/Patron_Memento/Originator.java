package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.auxiliar.Snapshoot;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.objeto.PersonajeOb;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

public class Originator {
    private Snapshoot _Estado;
    public Originator() {
        _Estado = new Snapshoot();
    }

    public void nuevoEstado(Character pCharacter) {
        this._Estado.nuevaInstantanea(pCharacter);
    }
    public Character obtenerEstado(int pIdx) {
        return this._Estado.obtenerInstantanea().get(pIdx);
    }

    public String obtenerEstado() {
        return "Originador> estado actual [" +
                this._Estado.obtenerInstantanea().get(0);
    }

/*==========================================================================
 *						 Seccion donde usamos el memento.
 ==========================================================================*/

    public void restaurarMemento(Memento m) {
        this._Estado.nuevaInstantanea (m.obtenerMemento(0));

    }

    public Memento crearMemento(PersonajeOb personajeOb) {
        return new Memento(this._Estado.obtenerInstantanea().get(0));
    }




}//
