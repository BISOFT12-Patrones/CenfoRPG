package com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaConcreta;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoConcreto.Arquero;

public class FabricaArquero implements GameCharacter {

    public FabricaArquero(){

    }

    @Override
    public Character createCharacter(){
        Arquero myCharacter=new Arquero();
        myCharacter.info_Character();
        return myCharacter;

    }




}
