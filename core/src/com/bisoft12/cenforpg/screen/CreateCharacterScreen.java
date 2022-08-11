package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class CreateCharacterScreen implements Screen {
    private Render render;
    private Inputs input;
    private Pantalla screen;

    private Texture arquero, mago, caballero;

    private Text titulo, txtarquero, txtmago, txtcaballero;

    private Images image;

    public CreateCharacterScreen() {
        input = new Inputs();
        arquero = new Texture("assets/characters/mainCharacters/Arquero/pickarquero.png");
        caballero = new Texture("assets/characters/mainCharacters/Caballero/pickcaballero.png");
        mago = new Texture("assets/characters/mainCharacters/Mago/pickmago.png");
        image = new Images("assets/background/pickcharacterbackground.png");
        titulo = new Text(Resources.MENU_FONT, 160, 450, 40, "Seleccione su personaje");
        txtarquero = new Text(Resources.MENU_FONT, 140, 200, 25, "Arquero");
        txtcaballero = new Text(Resources.MENU_FONT, 330, 200, 25, "Caballero");
        txtmago = new Text(Resources.MENU_FONT, 560, 200, 25, "Mago");
        txtarquero.setFontSize(20);
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
        txtarquero.draw();
        txtcaballero.draw();
        txtmago.draw();
        titulo.draw();
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
