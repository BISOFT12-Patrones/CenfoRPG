package com.bisoft12.cenforpg.patterns.Creational.FabricaConcreta;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft12.cenforpg.patterns.Creational.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.ProductoConcreto.Caballero;

public class FabricaCaballero implements GameCharacter {
    public FabricaCaballero(){

    }

    @Override
    public Character createCharacter(){
        Caballero myCharacter=new Caballero();
        myCharacter.info_Character();
        return myCharacter;

    }



}
