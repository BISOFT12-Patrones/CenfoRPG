package com.bisoft12.cenforpg.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Render {

    public static SpriteBatch _Batch;

    public static void clearScreen() {
        ScreenUtils.clear(0, 0, 0, 1);
    }

    public static void clearScreen(float pR, float pG, float pB, float pA) {
        ScreenUtils.clear(pR, pG, pB, pA);
    }

    public static void close() {
        Gdx.app.exit();
    }
    public static void print(String texto) {
        System.out.println(texto);
    }

}
