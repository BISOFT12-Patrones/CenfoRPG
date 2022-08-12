package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class LoreScreen implements Screen {
    private Text text;
    private ShapeRenderer border;
    private float alpha;
    private float sum;
    private int contadorPalabras;
    private Inputs input;
    private Images background;

    public LoreScreen() {
        this.text = new Text(Resources.GAME_FONT, 50, 400, 22,
                "¡Vamos despierta que vas a llegar tarde!" + "\n" +
                        "…." + "\n" +
                        "¡Qué bien, has despertado! Recuerda que hoy es el día " + "\n" +
                        "donde escoges tu profesión, ya sabes caballero, mago o arquero. " + "\n" +
                        "Vamos alístate que el comandante los reúne a todos " + "\n" +
                        "en el gran palacio del reino y va a estar Nado, " + "\n" +
                        "el rey del mundo onírico." + "\n");
        this.border = new ShapeRenderer();
        this.background = new Images(Resources.LORE_BACKGROUND);
        this.input = new Inputs();
        this.sum = 0.0008F;
        this.alpha = 0;
    }
    @Override
    public void show() {
        this.background.setsize(800, 800);
        this.text.setColor(Color.BLACK);
        /*getLetter();*/
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        Render.Batch.begin();
        this.background.draw();
        this.text.draw();
        Render.Batch.end();
        loadMenuScreen();
        nextText();

    }
    @Override
    public void resize(int width, int height) {

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

    }

    private void loadMenuScreen() {
        if (this.input.isUp() || this.input.isDown() || this.input.isEnter()) {
            Resources.MAIN.setScreen(new MenuScreen());
        }
    }

    private void nextText() {
        this.alpha += this.sum;
        if (this.alpha >= 0.6) {
            this.text.setText("El rey Nado necesita tu ayuda para derrotar a los" + "\n" +
                    "malvados elementos que se estan apoderando " + "\n" +
                    "del reino onirico. Escoge de manera sabia," + "\n" +
                    "Caballero, Mago o Arquero.");
            this.text.setCoordinates(80, 400);
        }
        if (this.alpha >= 1) {
            this.text.setText("Armate de agallas y alistate para defender al reino onirico");
            this.text.setCoordinates(80, 400);
        }

    }

   /* private void getLetter() {
        String text = "";
        for (int i = 0; i < this._Text.getText().length(); i++) {
            text = text + this._Text.getText().charAt(i);

            if (text.length() > this._Text.getText().length()) {
                text += "\n";
            }
        }
        this._Text.setText(text);
    }*/

}
