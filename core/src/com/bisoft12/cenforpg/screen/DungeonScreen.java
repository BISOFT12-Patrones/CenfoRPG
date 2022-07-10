package com.bisoft12.cenforpg.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;

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
        player = new Player(this.screen.getWorld());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        render.clearScreen();
        screen.update(delta);
        this.screen.getWorld().step(1 / 60f, 6, 2);
        handleInput();
        screen.getCAMERA().position.x = player.b2Body.getPosition().x;
        screen.getCAMERA().position.x = player.b2Body.getPosition().y;
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

    private void handleInput() {
        if (input.isUp()) {
            player.setPosX(player.getPosY() + 4);
        }
        if (input.isDown()) {
            player.setPosX(player.getPosY() - 4);
        }

        if (input.isRight()) {
            player.setPosX(player.getPosX() + 4);
        }

        if (input.isLeft()) {
            player.setPosX(player.getPosX() - 4);
        }
        player.positionUpdate();
    }
}
