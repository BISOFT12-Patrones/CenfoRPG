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
        this.text = new Text(Resources.MENU_FONT, 80, 300, 22,
                "Tras acabar con los reinos del agua, viento, tierra y aire," + "\n" +
                        "los cuatro malvados elementos, van por mas, ellos quieren" + "\n" +
                        "conquistar los cuatro reinos. Con la ayuda de los tres" + "\n" +
                        "guerreros podremos derrotar a los malvados elementos.");
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
        this.text.setCoordinates(50, 400);
        /*getLetter();*/
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        Render.batch.begin();
        this.background.draw();
        this.text.draw();
        Render.batch.end();
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
        if (this.alpha >= 0.4) {
            this.text.setText("Los tres guerreros: El caballero, encargado de batallar" + "\n" +
                    "duramente, El mago, encargado de la magia y de asuntos fuera" + "\n" +
                    "de este mundo y El arquero, encargado" + "\n" +
                    "de no equivocarse en ningun tiro contra enemigos");
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
