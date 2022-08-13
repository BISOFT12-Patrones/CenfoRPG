package com.bisoft12.cenforpg.patterns.Structural.Composite.components;

import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;

import java.util.ArrayList;

public class NpcZone extends iComponent {
    ArrayList<iComponent> npcType;
    public NpcZone(String pNombre) {
        this.setNodeType(iComponent.ZONE);
        this.setName(pNombre);
        this.npcType = new ArrayList<iComponent>();
    }
    @Override
    public String talk() {
        System.out.println("esta es una excepcion, funcion no implementada");
        return "";
    }
    @Override
    public void addComponent(iComponent component) {
        this.npcType.add(component);
    }

    @Override
    public ArrayList<iComponent> getComponents() {
        return npcType;
    }
}