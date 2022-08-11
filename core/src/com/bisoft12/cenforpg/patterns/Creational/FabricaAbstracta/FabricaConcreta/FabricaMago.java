package com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaConcreta;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoConcreto.Mago;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

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
