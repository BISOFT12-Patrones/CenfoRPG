package com.bisoft12.cenforpg.patterns.Structural.Composite.components;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;

public class NPC extends iComponent {

    private Player player;
    private Texture texture;

    private int attack;

    private int defense;


    public NPC(float pX, float pY, World screen){
        texture = new Texture("characters/nonPlayableCharacters/NPC Adulto 1/Group 88.png");
       // player = new Player(texture, pX,pY,screen);
    }

    @Override
    public void draw() {

    }
}
