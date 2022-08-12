package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class MenuScreen implements Screen {
    private Images back;
    private Inputs input;
    /* private Text info;*/

    private Text gameName;
    private ArrayList<Text> options;

    private float alpha, sum;

    private int actual = 0;

    ShapeRenderer border;

    public MenuScreen() {
        this.sum = 0.0008F;
        this.alpha = 0;
        this.back = new Images(Resources.MENU_BACKGROUND);
        this.options = new ArrayList<Text>();
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        /* this.info = new Text(Resources.MENU_FONT, 10f, 100, 16, "Cordenadas X: Y:");*/
        this.gameName = new Text(Resources.GAME_FONT, 80, 354, 80, "Orden del Tiempo");
    }

    @Override
    public void show() {
        generateMenu();
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        Render.Batch.begin();
        this.back.draw();
        this.gameName.draw();
        for (Text mTemp : this.options) {
            mTemp.draw();
        }
        Render.Batch.end();
        /*validateMouse();*/
        validateKeys();
        showLoreScreen();
    }

    private void validateKeys() {
        try {
            int mTime = 200;
            if (this.input.isDown()) {
                this.actual++;
                if (this.actual > 1)
                    this.actual = 0;
                changeOptionColor(this.actual);
                Thread.sleep(mTime);
            }
            if (this.input.isUp()) {
                this.actual--;
                if (this.actual < 0)
                    this.actual = 1;
                changeOptionColor(this.actual);
                Thread.sleep(mTime);
            }
            if (this.input.isEnter()) {
                executeAction();
            }
        } catch (InterruptedException e) {
            Render.print(e.toString());
        }
    }

   /* private void validateMouse() {
        for (int i = 0; i < this.options.size(); i++) {
            float mX = this.input.getMouseX(), mY = this.input.getMouseY();
            Text mTemp = this.options.get(i);
            if (mX >= mTemp.getX() && mX <= (mTemp.getX() + mTemp.getWidth()))
                if (mY >= (mTemp.getY() - mTemp.getHeight()) && mY <= mTemp.getY())
                    changeOptionColor(i);
            if (this.input.isClicked())
                executeAction();
        }

    }*/

    private void executeAction() {
        switch (this.actual) {
            case 0:
                Resources.MAIN.setScreen(new TownScreen());
                this.dispose();

                //Tu gestor y objetos
                //aqui
                //Fin de tu gestor y objetos
                FabricaCharacter gestorCharacter = new FabricaCharacter();
                Character player = gestorCharacter.getCharacter();

                break;
            case 1:
                Render.close();
                break;

        }
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

   /* private void updateInfo() {
        this.info.setColor(Color.GRAY);
        this.info.setText("Coordenadas X: " + this.input.getMouseX() + " Y" + this.input.getMouseY());
    }*/

    private void generateMenu() {
        int mFontSize = 35;
        float mNextY = 0;
        int mRest = 50;
        this.gameName.setColor(Color.WHITE);
        this.options.add(new Text("Nuevo juego", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Salir", mFontSize, Resources.GAME_FONT));

        this.options.get(0).centerTextScreen();
        mNextY = this.options.get(0).getY();
        for (Text mTemp : this.options) {
            mTemp.centerTextScreen();
            mNextY -= mRest;
            mTemp.setY(mNextY);
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

    /*
     * Function: showLoreScreen
     * Descripcion: Esta funcion permite mostrar la pantalla del lore, esta funcion se activa una vez que se
     * cumple un tiempo establecido de inactividad en la pantalla de MenuScreen
     *@param  N/A
     *
     * @return N/A
     * */
    private void showLoreScreen() {
        if (!this.input.isEnter() && !this.input.isUp() && !this.input.isDown() && this.alpha >= 1) {
            Resources.MAIN.setScreen(new LoreScreen());
        } else {
            if (this.input.isEnter() || this.input.isUp() || this.input.isDown()) {
                this.alpha = 0f;
            } else {
                this.alpha += this.sum;
            }
        }
    }
} //394h 435w

