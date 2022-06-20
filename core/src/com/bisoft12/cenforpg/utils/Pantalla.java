package com.bisoft12.cenforpg.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.*;

public class Pantalla {

    private TmxMapLoader MAPLOADER;
    private TiledMap MAP;
    private OrthogonalTiledMapRenderer RENDERER;
    private MapProperties prop;
    private float scale;

    public OrthographicCamera CAMERA;
    public Viewport GAMEVIEW;


    public Pantalla(String pMap) {
        this.CAMERA = new OrthographicCamera();
        this.GAMEVIEW = new StretchViewport(Resources.WIDTH, Resources.HEIGHT, this.CAMERA);

        scale = Gdx.graphics.getWidth() / 800f;

        this.MAPLOADER = new TmxMapLoader();
        this.MAP = MAPLOADER.load(pMap);
        this.RENDERER = new OrthogonalTiledMapRenderer(this.MAP, scale);

        sizeMap();

    }

    //Metodos publicos

    public void movementCamera() {
        this.CAMERA.position.x += 1;
    }

    public void update(float pDelta) {
        //movementCamera();
        this.CAMERA.update();
        this.RENDERER.setView(CAMERA);
        this.RENDERER.render();

    }

    public void dispose() {
        //Limpiamos cuando se salga de la pantalla
        this.MAP.dispose();
        this.RENDERER.dispose();
    }

    //Metodos privados

    private void sizeMap() {
        this.prop = MAP.getProperties();

        int mapWidth = prop.get("width", Integer.class);
        int mapHeight = prop.get("height", Integer.class);
        int tilePixelWidth = prop.get("tilewidth", Integer.class);
        int tilePixelHeight = prop.get("tileheight", Integer.class);

        int mapPixelWidth = mapWidth * tilePixelWidth;
        int mapPixelHeight = mapHeight * tilePixelHeight;

        System.out.println(mapPixelWidth);
        System.out.println(mapPixelHeight);

        this.CAMERA.position.set(mapPixelWidth / 2, mapPixelHeight / 2, 0);
    }


}