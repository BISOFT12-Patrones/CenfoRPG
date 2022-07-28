package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Dialogs;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

public class TownScreen implements Screen {

    private Render render;
    private Inputs inputs;


    private Pantalla screen;

    private Dialogs dialogs;

    public TownScreen() {
        this.screen = new Pantalla("maps/map/townMap.tmx");
        this.dialogs = new Dialogs();
    }

    @Override
    public void show() {
        this.dialogs.getImage().setsize(150, Resources.WIDTH);
        this.dialogs.setCoordinates();
        this.dialogs.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        for (int i = 0; i < dialogs.getText().length(); i++) {
            if (dialogs.getText().charAt(i) == ' ') {
                System.out.println(dialogs.getText().charAt(i));
            }
        }
    }

    @Override
    public void render(float delta) {
        Render.clearScreen();
        this.screen.update(delta);
        Render.Batch.begin();
        this.dialogs.draw();
        Render.Batch.end();
    }

    @Override
    public void resize(int width, int height) {
        screen.resize(width, height);
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
        screen.dispose();
    }
}
