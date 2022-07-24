package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;


public class CityScreen implements Screen {

    //Para el jugador
    private Render render;
    private Inputs input;
    private Pantalla screen;
    private Player player;

    public CityScreen() {
        input = new Inputs();
        screen = new Pantalla("maps/map/city.tmx");

        int[] layers = {1, 2};
        screen.Box2DMaplayers(layers);

       //player = new Player("characters/mainCharacters/Arquero/Arquero_Frente1.png", 244, 242, this.screen.getWorld());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        render.clearScreen();
        screen.update(delta);

        inputHandler();


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
    private void inputHandler() {
        if (input.isUp() || input.isDown() || input.isRight() || input.isLeft()) {
            if (input.isDown()) {
                player.move("down");
            }
            if (input.isLeft()) {
                player.move("left");
            }
            if (input.isRight()) {
                player.move("right");
            }
            if (input.isUp()) {
                player.move("up");
            }
        } else {
            player.move("none");
        }

        //System.out.println(player.getX() +","+player.getY());
    }

}//End of class
