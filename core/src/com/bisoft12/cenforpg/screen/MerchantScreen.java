package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.screen.MerchantMenu.Merchant_MenuArmas;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class MerchantScreen implements Screen {
    private Images back;
    private Inputs input;
    private com.bisoft12.cenforpg.elements.Text gameName;
    private ArrayList<Text> options;
    private float alpha, sum;
    private int actual = 0;
    ShapeRenderer border;
    Sound sound;

    public MerchantScreen() {
        this.sum = 0.0008F;
        this.alpha = 0;
        this.back = new Images(Resources.MENU_Merchant);
        this.options = new ArrayList<Text>();
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.GAME_FONT, 50, 450, 50, "Deprisa! \nEligue la mejor opcion:\n");
    }

    @Override
    public void show() {
        generateMenu();
        Gdx.input.setInputProcessor(this.input);
        sound = Gdx.audio.newSound(Gdx.files.internal("music/MerchantMusic.mp3"));
        sound.play();
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
            case 0: //Armas
                Resources.MAIN.setScreen(new Merchant_MenuArmas());//
                this.dispose();
                sound.stop();
                break;
            case 1: //Armaduras
                //Enviar al Patron Prototipo el ID
                Resources.MAIN.setScreen(new TerrainMonster());
                this.dispose();
                sound.stop();
                break;
            case 2: //Pociones
                Resources.MAIN.setScreen(new TownScreen());//
                this.dispose();
                sound.stop();
                break;
            case 3: //Salir
                Resources.MAIN.setScreen(new CityScreen());
                this.dispose();
                sound.stop();
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
        this.options.add(new Text("Armas", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Armaduras", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Pociones", mFontSize, Resources.GAME_FONT));
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

}//End of class

