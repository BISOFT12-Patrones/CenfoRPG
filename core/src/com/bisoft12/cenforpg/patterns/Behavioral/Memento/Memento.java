package com.bisoft12.cenforpg.patterns.Behavioral.Memento;
import com.bisoft12.cenforpg.patterns.Behavioral.Memento.auxiliar.Snapshoot;

import java.util.ArrayList;

public class Memento {
    private Snapshoot _Snapshoot;
    private Snapshoot get_Snapshoot() {
        return _Snapshoot;
    }

    public Memento(int pLevel, int pExperience) {
        this._Snapshoot = new Snapshoot();
        this.get_Snapshoot().nuevaInstantanea(pLevel,pExperience);
    }

    public ArrayList<String> obtenerMemento() {
        return _Snapshoot.obtenerInstantanea();
    }

    public String obtenerMemento(int pIndex) {
        return _Snapshoot.obtenerInstantanea().get(pIndex);
    }



}//
