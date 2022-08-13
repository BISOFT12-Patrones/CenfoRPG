package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.auxiliar;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

import java.util.ArrayList;

public class Snapshoot {

    private Character character;

    public void nuevaInstantanea(Character pCharacter) {
        this.character = pCharacter;
    }

    public ArrayList<Character> obtenerInstantanea(){
        ArrayList<Character> snapshoot = new ArrayList<Character>();
        snapshoot.add(character);
        return snapshoot;
    }


}//
