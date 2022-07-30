package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Dialogs;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class TownScreen implements Screen {

    private Render render;
    private Inputs inputs;

    private int cont;

    private Pantalla screen;

    private Dialogs dialogs;

    public TownScreen() {
        this.screen = new Pantalla("maps/map/townMap.tmx");
        this.dialogs = new Dialogs();
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
                Thread.sleep(200);
            }
            if (this.cont == 1) {
                this.dialogs.setText("Juss wakin' up in tha mornnin', " +
                        "gotta thank God I don't know but today seems kinda odd No barkin' " +
                        "from the dog, no smog And momma cooked a breakfast with no hog I got my grub on" +
                        ", but didn't pig out Finally got a call from a girl I wanna dig out Hooked it up fo' later as I hit the do' Thinkin");
            }
            if (this.cont == 2) {
                this.dialogs.setText("Will I live another twenty-fo'?" +
                        "I gotta go 'cause I got me a drop top" +
                        "And if I hit the switch, I can make the ass drop" +
                        "Had to stop, at a red light" +
                        "Lookin' in my mirror, not a jacker in sight");
            }
            if (this.cont == 3) {
                this.dialogs.setText("Today was Good Day");
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
