package com.bisoft12.cenforpg.utils.InteractiveObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Structural.Proxy.Main.GestorProxyLlaveCalabozo;
import com.bisoft12.cenforpg.utils.InteractiveTileObject;

public class Dungeon extends InteractiveTileObject {

    public Dungeon(World pWorld, TiledMap pMap, Rectangle pBounds ){
        super(pWorld,pMap, pBounds);

        FIXTURE.setUserData(this);
    }

    @Override
    public void onHit() {
        Gdx.app.log("DungeonEarth", "Collision");
        GestorProxyLlaveCalabozo gestor = new GestorProxyLlaveCalabozo();
        FabricaCharacter gestorCharacter = new FabricaCharacter();

        Character player = gestorCharacter.getCharacter();
       // player.setKey(true);

        gestor.dungeonAcces(player);

    }
}
