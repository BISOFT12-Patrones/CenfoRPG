package com.bisoft12.cenforpg.utils.InteractiveObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Structural.Composite.base.iComponent;
import com.bisoft12.cenforpg.patterns.Structural.Composite.compositeGestor;
import com.bisoft12.cenforpg.utils.InteractiveTileObject;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class King extends InteractiveTileObject {

    private compositeGestor npcGestor;
    public King(World pWorld, TiledMap pMap, Rectangle pBounds ){
        super(pWorld,pMap, pBounds);
        FIXTURE.setUserData(this);
        npcGestor = new compositeGestor();
    }


    @Override
    public void onHit() {
        FabricaCharacter gestor = new FabricaCharacter();
        String text = "Yo, el rey Nado, te otorgo esta llave!";
        Resources.dialog = text;

        gestor.getCharacter().setKey(true);

        Gdx.app.log("Rey", "Collision");
    }

}