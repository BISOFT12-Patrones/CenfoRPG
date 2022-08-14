package com.bisoft12.cenforpg.patterns.Structural.Composite;

import com.badlogic.gdx.graphics.Texture;
import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;
import com.bisoft12.cenforpg.patterns.Structural.Composite.components.NPC;
import com.bisoft12.cenforpg.patterns.Structural.Composite.components.NpcType;
import com.bisoft12.cenforpg.patterns.Structural.Composite.components.NpcZone;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class compositeGestor {
    private static ArrayList<iComponent> npcComposite;

    public compositeGestor() {
        if(npcComposite == null){
            npcComposite = new ArrayList<>();
        }
    }

    private void newZone(String pName){
        NpcZone zone = new NpcZone(pName);
        npcComposite.add(zone);
    }

    private iComponent getZone(String pName){
        for (iComponent zone:
             npcComposite) {
            if(pName.equals(zone.getName())){
                return zone;
            }
        }
        return null;
    }

    private void newType(String pZone, String pName){
        for (iComponent zone: npcComposite) {
            if(pZone.equals(zone.getName())){
                NpcType type = new NpcType(pName);
                zone.addComponent(type);
            }
        }
    }

    private iComponent getType(String pZone, String pName){
        for (iComponent zone: npcComposite) {
            if(pZone.equals(zone.getName())){
                for (iComponent type: zone.getComponents()) {
                    if(pName.equals(type.getName())){
                        return type;
                    }
                }
            }
        }
        return null;
    }

    public void newNpc(int i){
        String[] names = {"Pedro", "Juan", "Nado"};
        String pZone = Resources.CURRENT_LOCATION;
        String pType = "Good";
        String pName = names[i];
        int attack = 0;
        int defense = 0;
        String[] dialogs = {"Debes buscar al rey!", "Yo, el rey Nado, te otorgo esta llave!"};
        String dialog = i == 2 ? dialogs[1]:dialogs[0];
        Boolean hasDialog = true;
        Boolean isKing = i == 2;

        if (!existsZone(pZone)) {
            newZone(pZone);
        }
        if (!existsType(pZone, pType)) {
            newType(pZone, pType);
        }
        if(!existsNpc(pZone,pType,pName)){
            addNpc(pZone, pType, pName,attack, defense, dialog ,hasDialog, isKing);
        }
    }

    private void addNpc(String pZone, String pType, String pName, int attack, int defense, String dialog, Boolean hasDialog, Boolean isKing ){
        for (iComponent zone: npcComposite) {
            if(pZone.equals(zone.getName())){
                for (iComponent type: zone.getComponents()) {
                    if(pType.equals(type.getName())){
                        NPC npc = new NPC(pName,attack,defense,dialog,hasDialog,isKing);
                        type.addComponent(npc);
                    }
                }
            }
        }
    }
    public iComponent getNpc(String pZone, String pType, String pName){
        for (iComponent zone: npcComposite) {
            if(pZone.equals(zone.getName())){
                for (iComponent type: zone.getComponents()) {
                    if(pType.equals(type.getName())){
                        for (iComponent npc: type.getComponents()) {
                            if(pName.equals(npc.getName())){
                                return npc;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }


    public boolean existsZone(String pName){
        for (iComponent zone:
                npcComposite) {
            if(pName.equals(zone.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean existsType(String pZone, String pName){
            for (iComponent zone: npcComposite) {
                if(pZone.equals(zone.getName())){
                    for (iComponent type: zone.getComponents()) {
                        if(pName.equals(type.getName())){
                            return true;
                        }
                    }
                }
            }
            return false;
    }

    public boolean existsNpc(String pZone, String pType, String pName){
        for (iComponent zone: npcComposite) {
            if(pZone.equals(zone.getName())){
                for (iComponent type: zone.getComponents()) {
                    if(pType.equals(type.getName())){
                        for (iComponent npc: type.getComponents()) {
                            if(pName.equals(npc.getName())){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<iComponent> getArrayNpcs(){
        return npcComposite;
    }

}
