package com.bisoft12.cenforpg.utils;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.bisoft12.cenforpg.patterns.Structural.Composite.compositeGestor;
import com.bisoft12.cenforpg.utils.InteractiveObjects.*;

public class Box2DHelper {

    private World WORLD;
    private Box2DDebugRenderer B2DR;

    private BodyDef BDEF;
    private PolygonShape SHAPE;
    private FixtureDef FDEF;
    private Body BODY;

    private compositeGestor npcGestor;

    public World getWORLD() {
        return WORLD;
    }

    public Box2DDebugRenderer getB2DR() {
        return B2DR;
    }


    public Box2DHelper(World pWorld) {
        WORLD = pWorld;
        B2DR = new Box2DDebugRenderer();
        B2DR.setDrawBodies(false);
        BDEF = new BodyDef();
        SHAPE = new PolygonShape();
        FDEF = new FixtureDef();
        npcGestor = new compositeGestor();
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

    public void npcObject(TiledMap pMap, int pIdLayer) {
        int i = 0;
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            npcGestor.newNpc(i);
            new Npc(WORLD, pMap, rect);
            i++;
        }

    }

    public void kingObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new King(WORLD, pMap, rect);
        }
    }

    public void houseObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new House(WORLD, pMap, rect);

        }

    }

    public void merchantObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Merchant(WORLD, pMap, rect);

        }

    }

    public void cityObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new City(WORLD, pMap, rect);

        }

    }

    public void dungeonObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Dungeon(WORLD, pMap, rect);

        }

    }

    public void terrainObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new Terrain(WORLD, pMap, rect);

        }

    }
    public void monsterObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new MonsterZones(WORLD, pMap, rect);

        }

    }
    public void jefeObject(TiledMap pMap, int pIdLayer) {
        for (MapObject object : pMap.getLayers().get(pIdLayer).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            new JefeTierra(WORLD, pMap, rect);

        }

    }
    public void dispose() {
        System.out.println(WORLD.getBodyCount());
        Array<Body> bodies = new Array<Body>(WORLD.getBodyCount());
        WORLD.getBodies(bodies);
        for (Body body : bodies) {
            WORLD.destroyBody(body);
        }
    }
}
