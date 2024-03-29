package com.bisoft12.cenforpg.screen.MerchantMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Dialogs;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.screen.CityScreen;
import com.bisoft12.cenforpg.screen.MerchantScreen;
import com.bisoft12.cenforpg.screen.TerrainMonster;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;
import java.util.Objects;

public class Merchant_MenuArmas implements Screen {
    private Images back;
    private Inputs input;
    private com.bisoft12.cenforpg.elements.Text gameName;
    private ArrayList<Text> options;
    private float alpha, sum;
    private int actual = 0;
    ShapeRenderer border;
    private FabricaCharacter gestorCharacter = new FabricaCharacter();
    private Dialogs dialogs;

    public Merchant_MenuArmas() {
        this.sum = 0.0008F;
        this.alpha = 0;
        this.back = new Images(Resources.MENU_Merchant);
        this.options = new ArrayList<Text>();
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.GAME_FONT, 50, 450, 50, "Elige un Arma");
        this.dialogs = new Dialogs();
    }

    @Override
    public void show() {
        generateMenu();
        this.dialogs.getImage().setsize(150, Resources.WIDTH);

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
        if (!Objects.equals(Resources.dialog, "")) {
            this.dialogs.setText(Resources.dialog);
            this.dialogs.draw();
        }
        Render.Batch.end();
        validateMouse();
        validateKeys();
    }

    private void validateKeys() {
        try {
            int mTime = 200;
            if (this.input.isDown()) {
                this.actual++;
                if (this.actual > 4)
                    this.actual = 0;
                changeOptionColor(this.actual);
                Thread.sleep(mTime);
            }
            if (this.input.isUp()) {
                this.actual--;
                if (this.actual < 0)
                    this.actual = 4;
                Thread.sleep(mTime);
                changeOptionColor(this.actual);
            }
            if (this.input.isEnter()) {
                if (Resources.dialog.equals(""))
                    executeAction();
                else
                    Resources.dialog = "";
            }
            Thread.sleep(mTime);
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
                if (gestorCharacter.getCharacter().getTipeCharacter().equals("Caballero")) {
                    //Enviar al Patron Prototipo el id
                    Resources.MAIN.setScreen(new Merchant_MenuEspada());
                } else {
                    Resources.dialog = "Tiene que ser clase Caballero";
                }

                this.dispose();
                break;
            case 1:
                if (gestorCharacter.getCharacter().getTipeCharacter().equals("Arquero")) {
                    //Enviar al Patron Prototipo el id
                    Resources.MAIN.setScreen(new Merchant_MenuFlecha());
                } else {
                    Resources.dialog = "Tiene que ser clase Arquero";
                }

                this.dispose();
                break;
            case 2:

                if (gestorCharacter.getCharacter().getTipeCharacter().equals("Caballero")) {
                    //Enviar al Patron Prototipo el id
                    Resources.MAIN.setScreen(new Merchant_MenuHacha());
                } else {
                    Resources.dialog = "Tiene que ser clase Caballero";
                }
                this.dispose();
                break;

            case 3:
                if (gestorCharacter.getCharacter().getTipeCharacter().equals("Mago")) {
                    //Enviar al Patron Prototipo el id
                    Resources.MAIN.setScreen(new Merchant_MenuVarita());
                } else {
                    Resources.dialog = "Tiene que ser clase Mago";
                }

                break;
            case 4: //Salir
                Resources.MAIN.setScreen(new MerchantScreen());
                this.dispose();
                break;
        }
    }

    private void generateMenu() {
        int mFontSize = 35;
        float mNextY = 0;
        int mRest = 50;
        this.gameName.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        this.options.add(new Text("Espada", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Flecha", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Hacha", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Varita", mFontSize, Resources.GAME_FONT));
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
    public void resize(int i, int i1) {
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
