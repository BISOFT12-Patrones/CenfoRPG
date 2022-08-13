package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.auxiliar;

import java.util.ArrayList;

public class Snapshoot {
    private int _Level, _Experience;

    public void nuevaInstantanea(int pLevel, int pExperience) {
        this._Level = pLevel;
        this._Experience = pExperience;
    }

    public ArrayList<String> obtenerInstantanea(){
        ArrayList<String> snapshoot = new ArrayList<String>();
        snapshoot.add(this._Level);
        snapshoot.add(this._Experience);
        return snapshoot;
    }


}//
