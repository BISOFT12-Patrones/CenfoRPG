package com.bisoft12.cenforpg.patterns.Structural.Composite.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;

public class NPC extends iComponent {

    private Texture texture;
    private static Sprite sprite;
    private static int attack;

    private static int defense;
    private FabricaCharacter gestorCharacter = new FabricaCharacter();

    public NPC(int pLevel) {

        if (gestorCharacter.getCharacter().isDungeon()) {
            this.attack = (300);
            this.defense = (675);
            texture = new Texture(Gdx.files.internal("characters/nonPlayableCharacters/Monstruo_Tierra/big_zombie_idle_anim_f0-1.png"));
            sprite = new Sprite(texture, 32, 32);
            sprite.setPosition(300, 146);
        } else {
            this.attack = (pLevel * 110);
            this.defense = (pLevel * 155);
            randomTexture();
        }

    }

    public NPC() {

    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int pDefense) {
        this.defense -= pDefense;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void draw() {

    }

    private void randomTexture() {
        int numero = (int) (Math.random() * 10 + 1);

        if (numero >= 7) {
            texture = new Texture(Gdx.files.internal("characters/nonPlayableCharacters/Monstruo_Agua/ice_zombie_idle_anim_f0-3.png"));
            sprite = new Sprite(texture, 32, 32);
            sprite.setPosition(300, 146);
        } else if (numero >= 4 && numero < 7) {
            texture = new Texture(Gdx.files.internal("characters/nonPlayableCharacters/Monstruo_Fuego/imp_idle_anim_f1-2.png"));
            sprite = new Sprite(texture, 32, 32);
            sprite.setPosition(300, 146);
        } else {
            texture = new Texture(Gdx.files.internal("characters/nonPlayableCharacters/Monstruo_Tierra/big_zombie_idle_anim_f0-1.png"));
            sprite = new Sprite(texture, 32, 32);
            sprite.setPosition(300, 146);
        }

    }


}
