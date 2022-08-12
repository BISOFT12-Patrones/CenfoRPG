package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Dialogs;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.io.StatusText;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class TownScreen implements Screen {

    private Render render;
    private Inputs inputs;

    private int cont;

    private Pantalla screen;

    private Dialogs dialogs;

    private StatusText statusText;

    public TownScreen() {
        this.screen = new Pantalla("maps/map/townMap.tmx");
        this.dialogs = new Dialogs();
        this.statusText = new StatusText();
        this.inputs = new Inputs();
        this.cont = 0;
    }

    @Override
    public void show() {
        this.dialogs.getImage().setsize(150, Resources.WIDTH);
        this.dialogs.setCoordinates();
        Gdx.input.setInputProcessor(this.inputs);
    }

    @Override
    public void render(float delta) {

        Render.clearScreen();
        this.screen.update(delta);
        Render.Batch.begin();
        this.statusText.draw();
        if (this.cont > 0 && this.cont < 4) {
            this.dialogs.draw();
        }
        Render.Batch.end();
        validateKeys();
    }

    @Override
    public void resize(int width, int height) {
        screen.resize(width, height);
    }

    public void validateKeys() {
        try {

            if (this.inputs.isEnter()) {
                this.cont++;
                Player.setEXP(Player.getEXP() + 50);
                Thread.sleep(200);
            }
            if (this.cont == 1) {
                this.dialogs.setText("Hola");
            }
            if (this.cont == 2) {
                this.dialogs.setText("Mi nombre es");
            }
            if (this.cont == 3) {
                this.dialogs.setText("Test");
            }
            if (this.cont == 4) {
                this.cont = 0;

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
