package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.bisoft12.cenforpg.utils.Resources;

public class CityScreen implements Screen {

    //Variables para cargar el mapa
    private TiledMap mapa;
    private OrthogonalTiledMapRenderer render;
    private OrthographicCamera camera;

    @Override
    public void show() {
        TmxMapLoader loader = new TmxMapLoader();
        mapa = loader.load("maps/map/city.tmx");
        render = new OrthogonalTiledMapRenderer(mapa);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, (Resources.WIDTH / 2) + 100, Resources.HEIGHT / 2);
    }

    @Override
    public void render(float delta) {
        render.setView(camera);
        render.render();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        mapa.dispose();
        render.dispose();
    }
}//End of class
