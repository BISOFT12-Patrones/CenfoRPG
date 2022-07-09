package com.bisoft12.cenforpg.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class DungeonScreen implements Screen {

    private Pantalla screen;
    private Inputs input;
    private Render render;
    private Player player;

    public DungeonScreen() {
        input = new Inputs();
        screen = new Pantalla("maps/map/dungeon.tmx", 400, 118);

        //Para la creacion de box2D en los objetos del mapa
        int[] layers = {2, 3};
        screen.Box2DMaplayers(layers);

        player = new Player("characters/mainCharacters/Arquero/Arquero_Frente1.png", 244, 242, this.screen.getWorld());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        render.clearScreen();

        screen.update(delta);



     /*  render.Batch.begin();
        render.Batch.draw(player.getTexture(), player.getX(), player.getY(), 45, 40);

        render.Batch.end();*/

        inputHandler();
        screen.getCAMERA().position.x = player.getX();
        screen.getCAMERA().position.y = player.getY();
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

    }

    @Override
    public void dispose() {
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
}
