package com.bisoft12.cenforpg.patterns.Structural.Composite.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;

import java.util.ArrayList;

public class NPC extends iComponent {

    private int attack;
    private static int defense;
    private String dialog;
    private Boolean hasDialog;
    private Boolean isKing;
    private Texture texture;

    private static Sprite sprite;

    private FabricaCharacter gestorCharacter = new FabricaCharacter();


    public NPC(String pName, int attack, int defense, String dialog, Boolean hasDialog, Boolean isKing) {
        this.attack = attack;
        this.defense = defense;
        this.dialog = dialog;
        this.hasDialog = hasDialog;
        this.isKing = isKing;
        this.name = pName;
        this.nodeType = iComponent.NPC;
    }

    public NPC(int pLevel) {
        if (gestorCharacter.getCharacter().isFeje()) {
            this.attack = (pLevel * 110);
            this.defense = (pLevel * 200);
            texture = new Texture(Gdx.files.internal("assets/characters/nonPlayableCharacters/Jefes Finales/jefeTierraPeque.png"));
            sprite = new Sprite(texture);
            sprite.setPosition(550, 140);
        } else {
            if (gestorCharacter.getCharacter().isDungeon()) {
                this.attack = (pLevel * 110);
                this.defense = (pLevel * 175);
                texture = new Texture("assets/characters/nonPlayableCharacters/Monstruo_Tierra/big_zombie_idle_anim_f0-1Peque.png");
                sprite = new Sprite(texture);
                sprite.setPosition(550, 140);
            } else {
                this.attack = (pLevel * 110);
                this.defense = (pLevel * 155);
                randomTexture();
            }
        }

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

    public String getDialog() {
        return dialog;
    }

    public Boolean getHasDialog() {
        return hasDialog;
    }

    public Boolean getKing() {
        return isKing;
    }

    @Override
    public String talk() {
        return this.dialog;
    }

    @Override
    public void addComponent(iComponent component) {
        System.out.println("esta es una excepcion, funcion no implementada");
    }

    @Override
    public ArrayList<iComponent> getComponents() {
        return null;
    }

    public Sprite getSprite() {
        return sprite;
    }

    private void randomTexture() {
        int numero = (int) (Math.random() * 10 + 1);

        if (numero >= 7) {
            texture = new Texture("assets/characters/nonPlayableCharacters/Monstruo_Agua/ice_zombie_idle_anim_f0-2Peque.png");
            sprite = new Sprite(texture);
            sprite.setPosition(550, 140);
        } else if (numero >= 4 && numero < 7) {
            texture = new Texture("assets/characters/nonPlayableCharacters/Monstruo_Fuego/imp_idle_anim_f0-1Peque.png");
            sprite = new Sprite(texture);
            sprite.setPosition(550, 140);
        } else {
            texture = new Texture("assets/characters/nonPlayableCharacters/Monstruo_Tierra/big_zombie_idle_anim_f0-1Peque.png");
            sprite = new Sprite(texture);
            sprite.setPosition(550, 140);
        }

    }
}
