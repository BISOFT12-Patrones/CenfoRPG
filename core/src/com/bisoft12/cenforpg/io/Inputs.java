package com.bisoft12.cenforpg.io;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.bisoft12.cenforpg.utils.Resources;

public class Inputs implements InputProcessor {

    private boolean down = false, up = false, enter = false, clicked = false, left = false, right = false;
    private int mouseX, mouseY;

    //get

    public boolean isDown() {
        return down;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isEnter() {
        return enter;
    }

    public boolean isClicked() {
        return clicked;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    //set

    private void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    private void setMouseY(int mouseY) {
        this.mouseY = Resources.HEIGHT - mouseY;
    }


    //Override

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.DOWN)
            this.down = true;
        if (keycode == Input.Keys.UP)
            this.up = true;
        if (keycode == Input.Keys.LEFT)
            this.left = true;
        if (keycode == Input.Keys.RIGHT)
            this.right = true;
        if (keycode == Input.Keys.ENTER || keycode == Input.Keys.NUMPAD_ENTER)
            this.enter = true;

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.DOWN)
            this.down = false;
        if (keycode == Input.Keys.UP)
            this.up = false;
        if (keycode == Input.Keys.LEFT)
            this.left = false;
        if (keycode == Input.Keys.RIGHT)
            this.right = false;
        if (keycode == Input.Keys.ENTER || keycode == Input.Keys.NUMPAD_ENTER)
            this.enter = false;

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.clicked = true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this.clicked = false;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        this.setMouseX(screenX);
        this.setMouseY(screenY);

        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
