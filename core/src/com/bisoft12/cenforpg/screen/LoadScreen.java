package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Screen;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class LoadScreen implements Screen {

    private int contador;
    private Images companyLogo;
    private float sum, alpha;

    private boolean loaded, ready, pause;

    public LoadScreen() {
        this.companyLogo = new Images(Resources.COMPANY_LOGO);
        this.sum = 0.008F;
        this.alpha = 0;
        this.loaded = false;
        this.ready = false;
        this.pause = false;
        this.contador = 0;
    }

    @Override
    public void show() { // se llama cuando la pantalla se activa, inicializa variables y se ejecuta en una sola vez
        this.companyLogo.setsize(300, 400);
        this.companyLogo.setCoordinates(200, 180);
    }

    @Override
    public void render(float delta) { // cuando necesitamos que se muestre la pantalla con el
        // render aca es cuando se hacen todas las funcionalidades que necesitamos
        Render.clearScreen();
        Render.Batch.begin();
        this.companyLogo.draw();
        Render.Batch.end();
        if (this.loaded) {
            if (!this.pause) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.pause = true;
            }
            if (!this.ready)
                fadeOut();
            else {
                Resources.MAIN.setScreen(new MenuScreen());
                this.dispose();
            }
        } else
            fadeIn();


    }

    @Override
    public void resize(int width, int height) { // cuando necesitamos hacer un resize de la pantalla

    }

    @Override
    public void pause() { // es una funcion para poder hacer una pausa

    }

    @Override
    public void resume() { // es una funcion para volver a la pantalla

    }

    @Override
    public void hide() { // se llama cuando la pantalla ya no es la pantalla de un archivo

    }

    @Override
    public void dispose() { // hace una limpia en memoria
        this.companyLogo.dispose();
    }

    //Private Function

    private void fadeIn() {
        if (!this.loaded) {
            if (this.alpha >= 1) {
                this.loaded = true;
            } else {
                this.alpha += this.sum;
                this.companyLogo.setAlpha(this.alpha);
            }
        }

    }

    private void fadeOut() {
        if (!this.ready) {
            if (this.alpha < 0) {
                this.ready = true;
            } else {
                this.alpha -= this.sum;
                this.companyLogo.setAlpha(this.alpha);
            }
        }

    }

}
