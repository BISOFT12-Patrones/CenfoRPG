package com.bisoft12.cenforpg.patterns.Structural.Decorator.Decorator;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

public abstract class DecoratedPlayer implements Character {
    protected Character cCharacter;

    public Character getCharacter(){
        return cCharacter;
    }
}
