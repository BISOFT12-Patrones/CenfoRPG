package com.bisoft12.cenforpg.patterns.Structural.Composite.components;

import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;

import java.util.ArrayList;

public class NpcType extends iComponent {
    ArrayList<iComponent> npcs;
    public NpcType(String pNombre) {
        this.setNodeType(iComponent.TYPE);
        this.setName(pNombre);
        this.npcs = new ArrayList<iComponent>();
    }
    @Override
    public String talk() {
        System.out.println("esta es una excepcion, funcion no implementada");
        return "";
    }
    @Override
    public void addComponent(iComponent component) {
        this.npcs.add(component);
    }

    @Override
    public ArrayList<iComponent> getComponents() {
        return npcs;
    }
}
