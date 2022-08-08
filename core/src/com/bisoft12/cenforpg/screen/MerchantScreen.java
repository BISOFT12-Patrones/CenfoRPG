package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

import java.awt.*;
import java.util.ArrayList;

public class MerchantScreen implements Screen {
    private Images back;
    private Inputs input;
    private com.bisoft12.cenforpg.elements.Text gameName;
    private ArrayList<Text> options;
    private float alpha, sum;
    private int actual = 0;
    ShapeRenderer border;

    public MerchantScreen() {
        this.sum = 0.0008F;
        this.alpha = 0;
        this.back = new Images(Resources.MENU_Merchant);
        this.options = new ArrayList<Text>();
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.MENU_FONT, 80, 354, 50, "Comprar:");
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
        validateMouse();
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
                Resources.MAIN.setScreen(new TownScreen());//
                this.dispose();
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

    private void generateMenu() {
        int mFontSize = 35;
        float mNextY = 0;
        int mRest = 50;
        this.gameName.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        this.options.add(new Text("Armas", mFontSize, Resources.MENU_FONT));
        this.options.add(new Text("Armaduras", mFontSize, Resources.MENU_FONT));
        this.options.add(new Text("Pociones", mFontSize, Resources.MENU_FONT));
        this.options.add(new Text("Salir", mFontSize, Resources.MENU_FONT));

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
}//End of class

