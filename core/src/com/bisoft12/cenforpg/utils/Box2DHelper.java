package com.bisoft12.cenforpg.utils;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Box2DHelper {

    private World WORLD;
    private Box2DDebugRenderer B2DR;

    private BodyDef BDEF;
    private PolygonShape SHAPE;
    private FixtureDef FDEF;
    private Body BODY;


    public World getWORLD() {
        return WORLD;
    }

    public Box2DDebugRenderer getB2DR() {
        return B2DR;
    }


    public Box2DHelper(World pWorld) {
        WORLD = pWorld;
        B2DR = new Box2DDebugRenderer();

        BDEF = new BodyDef();
        SHAPE = new PolygonShape();
        FDEF = new FixtureDef();

    }

    public void create2DBoxes(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            BDEF.type = BodyDef.BodyType.StaticBody;
            BDEF.position.set((rect.getX() + rect.getWidth() / 2), (rect.getY() + rect.getHeight() / 2));

            SHAPE.setAsBox((rect.getWidth() / 2), (rect.getHeight() / 2));

            FDEF.shape = SHAPE;

            BODY = WORLD.createBody(BDEF);
            BODY.createFixture(FDEF);

        }
    }



}
