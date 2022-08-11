package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;

public class CreateCharacterScreen implements Screen {
    private Render render;
    private Inputs input;
    private Pantalla screen;

    private Texture arquero, mago, caballero;

    private Text txtarquero, txtmago, txtcaballero;

    private Images image;

    public CreateCharacterScreen() {
        input = new Inputs();
        arquero = new Texture("assets/characters/mainCharacters/Arquero/pickarquero.png");
        caballero = new Texture("assets/characters/mainCharacters/Caballero/pickcaballero.png");
        mago = new Texture("assets/characters/mainCharacters/Mago/pickmago.png");
        image = new Images("assets/background/pickcharacterbackground.png");

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void render(float delta) {
        render.clearScreen();
        render.Batch.begin();
        image.draw();
        render.Batch.draw(arquero, 150, 250);
        render.Batch.draw(caballero, 350, 250);
        render.Batch.draw(mago, 550, 250);
        render.Batch.end();
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
        dispose();
    }

    @Override
    public void dispose() {
        render.Batch.dispose();
    }
}
