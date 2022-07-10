package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Screen;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class TownScreen implements Screen {

    private Render render;
    private Inputs inputs;
    private Pantalla screen;

    public TownScreen() {
        this.screen = new Pantalla("maps/map/townMap.tmx");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Render.clearScreen();
        this.screen.update(delta);
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
        screen.dispose();
    }
}
