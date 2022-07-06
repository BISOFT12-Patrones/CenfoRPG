package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;

public class TerrainMonster implements Screen {


    //Para el jugador
    private Render render;
    private Inputs input;
    private Pantalla screen;
    private Player player;

    public TerrainMonster() {
        input = new Inputs();
        screen = new Pantalla("maps/map/terrainMonster.tmx" , 561,950);

        //Para la creacion de box2D en los objetos del mapa
        int[] layers = {1,2,3};
        screen.Box2DMaplayers(layers);
      /*  player = new Player(this.screen.getWorld());*/
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {

        render.clearScreen();

        screen.update(delta);



    }

    @Override
    public void resize(int width, int height) {
       screen.resize(width, height);
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
        screen.dispose();
    }


}