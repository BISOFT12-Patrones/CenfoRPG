package com.bisoft12.cenforpg.screen;


import com.badlogic.gdx.Screen;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;

public class DungeonScreen implements Screen {

    private Pantalla screen;
    private Render render;

    public DungeonScreen() {
        screen = new Pantalla("maps/map/dungeon.tmx");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        render.clearScreen();

        screen.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        screen.GAMEVIEW.update(width, height);
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
}
