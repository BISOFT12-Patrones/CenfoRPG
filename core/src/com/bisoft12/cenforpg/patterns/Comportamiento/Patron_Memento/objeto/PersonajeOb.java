package com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.objeto;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

public class PersonajeOb {
    private Character character;

    public PersonajeOb  (Character pCharacter) {
        setCharacter(pCharacter);
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

}//
