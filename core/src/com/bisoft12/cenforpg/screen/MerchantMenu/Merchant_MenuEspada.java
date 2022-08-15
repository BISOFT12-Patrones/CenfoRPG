package com.bisoft12.cenforpg.screen.MerchantMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.Principal.GestorPrototipo;
import com.bisoft12.cenforpg.screen.CityScreen;
import com.bisoft12.cenforpg.screen.TerrainMonster;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class Merchant_MenuEspada implements Screen {
    private Images back;
    private Inputs input;
    private com.bisoft12.cenforpg.elements.Text gameName;
    private ArrayList<Text> options;
    private float alpha, sum;
    private int actual = 0;
    ShapeRenderer border;

    private GestorPrototipo gestorPrototipo;

    public Merchant_MenuEspada() {
        this.sum = 0.0008F;
        this.alpha = 0;
        this.back = new Images(Resources.MENU_Merchant);
        this.options = new ArrayList<Text>();
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.GAME_FONT, 50, 450, 50, "Elige el Tipo de Espada");
        gestorPrototipo = new GestorPrototipo(0, 0, 0, 0);
    }

    @Override
    public void show() {
        generateMenu();
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float v) {
        Render.Batch.begin();
        this.back.draw();
        this.gameName.draw();
        for (Text mTemp : this.options) {
            mTemp.draw();
        }
        Render.Batch.end();
        validateMouse();
        validateKeys();
    }

    @Override
    public void resize(int i, int i1) {
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
                Thread.sleep(mTime);
                changeOptionColor(this.actual);
            }
            if (this.input.isEnter()) {
                executeAction();
            }
        } catch (InterruptedException e) {
            Render.print(e.toString());
        }
    }

    private void validateKeys() {
        try {
            int mTime = 200;
            if (this.input.isDown()) {
                this.actual++;
                if (this.actual > options.size()-1)
                    this.actual = 0;
                changeOptionColor(this.actual);
                Thread.sleep(mTime);
            }
            if (this.input.isUp()) {
                this.actual--;
                if (this.actual < 0)
                    this.actual = 1;
                Thread.sleep(mTime);
                changeOptionColor(this.actual);
            }
            if (this.input.isEnter()) {
                executeAction();
            }
        } catch (InterruptedException e) {
            Render.print(e.toString());
        }
    }

    private void validateMouse() {
        for (int i = 0; i < this.options.size(); i++) {
            float mX = this.input.getMouseX(), mY = this.input.getMouseY();
            Text mTemp = this.options.get(i);
            if (mX >= mTemp.getX() && mX <= (mTemp.getX() + mTemp.getWidth()))
                if (mY >= (mTemp.getY() - mTemp.getHeight()) && mY <= mTemp.getY())
                    changeOptionColor(i);
            if (this.input.isClicked())
                executeAction();
        }
    }

    private void executeAction() {
        switch (this.actual) {
            case 0:
                //Enviar al Patron Prototipo el id
                gestorPrototipo.nuevaArma(0, 4);
                System.out.println(gestorPrototipo.obtenerDatos() + "\n");
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 1:
                //Enviar al Patron Prototipo el id
                gestorPrototipo.nuevaArma(0, 5);
                System.out.println(gestorPrototipo.obtenerDatos() + "\n");
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 2:
                //Salir
                Resources.MAIN.setScreen(new CityScreen());
                this.dispose();
                break;
        }
    }

    private void generateMenu() {
        int mFontSize = 35;
        float mNextY = 0;
        int mRest = 50;
        this.gameName.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        this.options.add(new Text("Espada de Hierro", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Espada Plata", mFontSize, Resources.GAME_FONT));
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
            mTemp.setColor(com.badlogic.gdx.graphics.Color.WHITE);
            if (pId >= 0) {
                this.options.get(pId).setColor(Color.CHARTREUSE);
                this.actual = pId;
            }
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
    }

    @Override
    public void dispose() {
    }


}//
