package com.bisoft12.cenforpg.patterns.Structural.Decorator;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Structural.Decorator.ConcreteDecorator.armedCharacter;

public class gestorDecorator {
    public Character decorateCharacter(Character pCharacter, int pAttack, int pDefense){
        return new armedCharacter(pCharacter, pAttack, pDefense);
    }
}
