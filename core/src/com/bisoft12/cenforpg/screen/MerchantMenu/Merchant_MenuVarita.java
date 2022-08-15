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

public class Merchant_MenuVarita implements Screen {

    private Images back;
    private Inputs input;
    private com.bisoft12.cenforpg.elements.Text gameName;
    private ArrayList<Text> options;
    private float alpha, sum;
    private int actual = 0;
    ShapeRenderer border;

    private GestorPrototipo gestorPrototipo;

    public Merchant_MenuVarita() {
        this.sum = 0.0008F;
        this.alpha = 0;
        this.back = new Images(Resources.MENU_Merchant);
        this.options = new ArrayList<Text>();
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.GAME_FONT, 50, 450, 50, "Elige el Tipo de Varita");
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
                if (this.actual > 9)
                    this.actual = 0;
                changeOptionColor(this.actual);
                Thread.sleep(mTime);
            }
            if (this.input.isUp()) {
                this.actual--;
                if (this.actual < 0)
                    this.actual = 9;
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
                if (this.actual > 10)
                    this.actual = 0;
                changeOptionColor(this.actual);
                Thread.sleep(mTime);
            }
            if (this.input.isUp()) {
                this.actual--;
                if (this.actual < 0)
                    this.actual = 10;
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
            case 0: //Recuperacion 5
                gestorPrototipo.nuevaArma(3, 13);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 1: //Soplo de hielo
                gestorPrototipo.nuevaArma(3, 14);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 2: //Lanzallamas
                gestorPrototipo.nuevaArma(3, 15);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 3: //Rama Afilada
                gestorPrototipo.nuevaArma(3, 16);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 4: //Ciclon
                gestorPrototipo.nuevaArma(3, 17);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 5: //Recuperacion 20%
                gestorPrototipo.nuevaArma(3, 19);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 6: //Claridad Mental
                gestorPrototipo.nuevaArma(3, 18);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 7: //Vitalidad Grupal
                gestorPrototipo.nuevaArma(3, 20);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 8: //Bomba de Hielo
                gestorPrototipo.nuevaArma(3, 21);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 9: //Fundir
                gestorPrototipo.nuevaArma(3, 22);
                System.out.println(gestorPrototipo.obtenerDatos());
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                break;
            case 10:
                Resources.MAIN.setScreen(new TerrainMonster());
                break;
        }
    }

    private void generateMenu() {
        int mFontSize = 20;
        float mNextY = 0;
        int mRest = 20;
        this.gameName.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        this.options.add(new Text("Recuperacion 5%", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Soplo de Hielo", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Lanzallamas", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Rama Afilada", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Ciclon", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Recuperacion 20%", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Claridad mental", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Vitalidad Grupal", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Bomba de hielo", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Fundir", mFontSize, Resources.GAME_FONT));
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

}
