package com.bisoft12.cenforpg.utils;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;


public abstract class InteractiveTileObject{
    protected World WORLD;
    protected TiledMap MAP;
    protected TiledMapTile TILE;
    protected Rectangle BOUNDS;
    protected Body BODY;

    protected Fixture FIXTURE;

    public InteractiveTileObject(World pWorld, TiledMap pMap, Rectangle pBounds){
        this.WORLD = pWorld;
        this.MAP =pMap;
        this.BOUNDS = pBounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((pBounds.getX() + pBounds.getWidth() / 2), (pBounds.getY() + pBounds.getHeight() / 2));

        shape.setAsBox((pBounds.getWidth() / 2), (pBounds.getHeight() / 2));

        fdef.shape = shape;

        BODY = pWorld.createBody(bdef);
        BODY.createFixture(fdef);

        FIXTURE = BODY.createFixture(fdef);
    }

    public abstract void onHit();


}
