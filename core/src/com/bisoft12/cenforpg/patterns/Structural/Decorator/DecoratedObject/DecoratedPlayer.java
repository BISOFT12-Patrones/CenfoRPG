package com.bisoft12.cenforpg.patterns.Structural.Decorator.DecoratedObject;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.patterns.Structural.Decorator.Component.MainCharacter;

public class DecoratedPlayer extends MainCharacter {
    protected MainCharacter cMainCharacter;


    public MainCharacter getMainCharacter(){
        return  cMainCharacter;
    }
}
