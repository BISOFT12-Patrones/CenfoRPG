package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class HouseScreen implements Screen {
    //Para el jugador
    private Render render;
    private Inputs input;
    private Pantalla screen;
    private Player player;

    public HouseScreen() {
        input = new Inputs();
        screen = new Pantalla("maps/map/house.tmx");
        player = new Player("characters/mainCharacters/Arquero/Arquero_Frente1.png", 388, 235, screen.getWorld());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {

        render.clearScreen();

        screen.update(delta);
        screen.getWorld().step(1/60f,6,2);
        render.Batch.begin();
        render.Batch.draw(player.getTexture(), player.getX(), player.getY(), 50,45);
        render.Batch.end();

        inputHandler();
    }

    @Override
    public void resize(int width, int height) {
        screen.resize(width, height);    }

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


    private void inputHandler(){
        if (input.isDown()){
            player.move("down");
        }
        if (input.isLeft()){
            player.move("left");
        }
        if (input.isRight()){
            player.move("right");
        }
        if (input.isUp()){
            player.move("up");
        }
       // System.out.println(player.getX() +","+player.getY());
    }

}