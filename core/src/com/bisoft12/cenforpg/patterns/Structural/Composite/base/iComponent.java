package com.bisoft12.cenforpg.patterns.Structural.Composite.base;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.characters.Player;

public abstract class iComponent{
    public static final int ZONE = 0;
    public static final int TYPE = 1;
    public static final int NPC = 2;

    protected String name;
    protected int nodeType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    //Abstracts
    public abstract void draw();
}
