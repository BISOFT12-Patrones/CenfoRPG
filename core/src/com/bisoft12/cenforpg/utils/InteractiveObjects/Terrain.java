package com.bisoft12.cenforpg.utils.InteractiveObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.screen.CityScreen;
import com.bisoft12.cenforpg.utils.InteractiveTileObject;

public class Terrain extends InteractiveTileObject {

    public Terrain(World pWorld, TiledMap pMap, Rectangle pBounds ){
        super(pWorld,pMap, pBounds);

        FIXTURE.setUserData(this);
    }

    @Override
    public void onHit() {
        CityScreen city = new CityScreen();
        Gdx.app.log("Terrain", "Collision");
        city.newScreen(3);
    }
}
