package com.bisoft12.cenforpg.patterns.Creational.FabricaConcreta;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft12.cenforpg.patterns.Creational.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.ProductoConcreto.Arquero;
import com.bisoft12.cenforpg.patterns.Creational.ProductoConcreto.Mago;

public class FabricaMago implements GameCharacter {

    public FabricaMago(){

    }

    @Override
    public Character createCharacter(){
        Mago myCharacter=new Mago();
        myCharacter.info_Character();
        return myCharacter;

    }

}
