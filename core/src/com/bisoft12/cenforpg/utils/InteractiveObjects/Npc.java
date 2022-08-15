package com.bisoft12.cenforpg.utils.InteractiveObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;
import com.bisoft12.cenforpg.patterns.Structural.Composite.components.NPC;
import com.bisoft12.cenforpg.patterns.Structural.Composite.compositeGestor;
import com.bisoft12.cenforpg.screen.HouseScreen;
import com.bisoft12.cenforpg.utils.InteractiveTileObject;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class Npc extends InteractiveTileObject {

    private compositeGestor npcGestor;
    public Npc(World pWorld, TiledMap pMap, Rectangle pBounds ){
        super(pWorld,pMap, pBounds);
        FIXTURE.setUserData(this);
        npcGestor = new compositeGestor();
    }


    @Override
    public void onHit() {
        iComponent zone = npcGestor.getZone(Resources.CURRENT_LOCATION);
        ArrayList<iComponent> type = zone.getComponents();
        iComponent npc = type.get(0).getComponents().get(0);
        Gdx.app.log("Npc", "Collision");
        String text = npc.talk();
        Resources.dialog = text;
    }

}
