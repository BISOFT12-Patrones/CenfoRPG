package com.bisoft12.cenforpg.patterns.Structural.Composite.components;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;

import java.util.ArrayList;

public class NPC extends iComponent {

    private int attack;
    private int defense;
    private String dialog;
    private Boolean hasDialog;
    private Boolean isKing;

    public NPC(String pName, int attack, int defense, String dialog, Boolean hasDialog, Boolean isKing) {
        this.attack = attack;
        this.defense = defense;
        this.dialog = dialog;
        this.hasDialog = hasDialog;
        this.isKing = isKing;
        this.name = pName;
        this.nodeType = iComponent.NPC;
    }


    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
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

}
