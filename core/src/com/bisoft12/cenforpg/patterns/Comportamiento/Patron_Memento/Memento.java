package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.auxiliar.Snapshoot;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

import java.util.ArrayList;

public class Memento {
    private Snapshoot _Snapshoot;
    private Character character;
    private Snapshoot get_Snapshoot() {
        return _Snapshoot;
    }

    public Memento(Character pCharacter) {
        this._Snapshoot = new Snapshoot();
        this.get_Snapshoot().nuevaInstantanea(pCharacter);
    }
    public ArrayList<Character> obtenerMemento() {
        return _Snapshoot.obtenerInstantanea();
    }

    public Character obtenerMemento(int pIndex) {
        return _Snapshoot.obtenerInstantanea().get(pIndex);
    }

}//
