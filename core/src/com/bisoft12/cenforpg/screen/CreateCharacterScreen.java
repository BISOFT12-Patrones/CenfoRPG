package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.Principal.GestorPrototipo;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class CreateCharacterScreen implements Screen {
    private Render render;
    private Inputs input;
    private Pantalla screen;

    private Texture arquero, mago, caballero;

    private Text titulo;

    private ArrayList<Text> options;
    private Images image;

    private FabricaCharacter gestorCharacter;

    private GestorPrototipo gestorPrototipo;

    private int actual = 0;

    public CreateCharacterScreen() {

        input = new Inputs();
        arquero = new Texture("assets/characters/mainCharacters/Arquero/pickarquero.png");
        caballero = new Texture("assets/characters/mainCharacters/Caballero/pickcaballero.png");
        mago = new Texture("assets/characters/mainCharacters/Mago/pickmago.png");
        image = new Images(Resources.CREATE_CHARACTER_BACKGROUND);
        titulo = new Text(Resources.GAME_FONT, 160, 450, 40, "Seleccione su personaje");
        options = new ArrayList<>();
        gestorCharacter = new FabricaCharacter();
        gestorPrototipo = new GestorPrototipo(0, 0, 0, 0);
    }

    @Override
    public void show() {
        generateMenu();
        Gdx.input.setInputProcessor(input);

    }

    @Override
    public void render(float delta) {
        render.clearScreen();
        render.Batch.begin();
        image.draw();
        titulo.draw();
        for (Text mText : this.options) {
            mText.draw();
        }
        render.Batch.draw(arquero, 150, 250);
        render.Batch.draw(caballero, 350, 250);
        render.Batch.draw(mago, 550, 250);
        render.Batch.end();
        validateKeys();
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
    }

    private void validateKeys() {
        try {
            if (this.input.isRight()) {
                this.actual++;
                if (this.actual > 2) {
                    this.actual = 0;
                }
                Thread.sleep(200);
                changeOptionColor(actual);
            }
            if (this.input.isLeft()) {
                this.actual--;
                if (this.actual < 0) {
                    this.actual = 2;
                }
                Thread.sleep(200);
                changeOptionColor(actual);
            }
            if (this.input.isEnter()) {
                executeAction();
            }
        } catch (InterruptedException e) {
            Render.print(e.toString());
        }
    }

    private void generateMenu() {
        int mFontSize = 25;

        this.options.add(new Text("Arquero", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Caballero", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Mago", mFontSize, Resources.GAME_FONT));

        for (int i = 0; i < options.size(); i++) {

            if (i == 0) {
                this.options.get(i).setX(140);
            }
            if (i == 1) {
                this.options.get(1).setX(330);
            }
            if (i == 2) {
                this.options.get(2).setX(560);
            }
            this.options.get(i).setY(200);

        }


        changeOptionColor(0);
    }

    private void changeOptionColor(int pId) {
        for (Text mTemp : this.options) {
            mTemp.setColor(Color.WHITE);
            if (pId >= 0) {
                this.options.get(pId).setColor(Color.FIREBRICK);
                this.actual = pId;
            }
        }
    }

    private void executeAction() {
        try {
            switch (this.actual) {
                case 0:
                    gestorCharacter.processFunction(1);
                    gestorCharacter.getCharacter().setArma(gestorPrototipo.nuevaArma(1, 7));
                    System.out.println(gestorCharacter.getCharacter().info_Character());
                    gestorCharacter.getCharacter().setExperience(300);
                    for (Arma arma : gestorCharacter.getCharacter().getArmas()) {
                        System.out.println(arma.getTipo().getNombre());
                    }
                    Resources.MAIN.setScreen(new CityScreen());
                    this.dispose();
                    break;

                case 1:
                    gestorCharacter.processFunction(2);
                    gestorCharacter.getCharacter().setArma(gestorPrototipo.nuevaArma(0, 4));
                    System.out.println(gestorCharacter.getCharacter().info_Character());
                    gestorCharacter.getCharacter().setExperience(300);
                    for (Arma arma : gestorCharacter.getCharacter().getArmas()) {
                        System.out.println(arma.getTipo().getNombre());
                    }
                    Resources.MAIN.setScreen(new CityScreen());
                    this.dispose();
                    break;

                case 2:
                    gestorCharacter.processFunction(3);
                    gestorCharacter.getCharacter().setExperience(300);
                    gestorCharacter.getCharacter().getArmas().add(gestorPrototipo.nuevaArma(3, 23));
                    gestorCharacter.getCharacter().getArmas().add(gestorPrototipo.nuevaArma(3, 24));
                    for (Arma arma : gestorCharacter.getCharacter().getArmas()) {
                        System.out.println(arma.getTipo().getNombre());
                    }
                    Resources.MAIN.setScreen(new CityScreen());
                    this.dispose();
                    break;
            }
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Render.print(e.toString());
        }

    }

}
