package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.bisoft12.cenforpg.utils.Resources;

public class HouseScreen implements Screen {

    //Variables para cargar el mapa
    private TiledMap mapa;
    private OrthogonalTiledMapRenderer render;
    private OrthographicCamera camera;


    @Override
    public void show() {
        //Cargamos el mapa
        TmxMapLoader loader = new TmxMapLoader();
        mapa = loader.load("maps/map/house.tmx");
        render = new OrthogonalTiledMapRenderer(mapa);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, (Resources.WIDTH / 2) + 100, Resources.HEIGHT / 2); //Como el mapa es más pequeño que la pantalla lo que hacemos es que dividimos entre
        // 2 la altura y el ancho de la pantalla para centrar el mapa
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
        dispose();
    }

    @Override
    public void dispose() {
        //Limpiamos cuando se salga de la pantalla
        mapa.dispose();
        render.dispose();
    }
}
