package com.bisoft12.cenforpg.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;


public class Text {
    private static final Color FONT_COLOR = Color.WHITE;
    private BitmapFont font;
    private GlyphLayout glayout;

    private float x, y;
    private int fontSize = 16;
    private String text;


    //Constructores
    public Text(String pText, int pFontSize) {
        initLayout();
        generateText(Resources.MENU_FONT, pFontSize, this.FONT_COLOR, false);
        this.setCoordinates(1f, 1f);
        this.setText(pText);
    }

    public Text(String pText, int pFontSize, String pFontSource) {
        initLayout();
        generateText(pFontSource, pFontSize, this.FONT_COLOR, false);
        this.setCoordinates(1f, 1f);
        this.setText(pText);
    }

    public Text() {
        initLayout();
        generateText(Resources.MENU_FONT, this.fontSize, FONT_COLOR, false);
        this.setCoordinates(100, 100f);
        this.setText("");
    }

    public Text(String pFontPath, float pX, float pY, int pFontSize, String pText) {
        initLayout();
        generateText(pFontPath, pFontSize, FONT_COLOR, false);
        this.setCoordinates(pX, pY);
        this.setText(pText);
    }

    public Text(String pFontPath, float pX, float pY, int pFontSize, String pText, boolean pShadow) {
        initLayout();
        generateText(pFontPath, pFontSize, FONT_COLOR, pShadow);
        this.setCoordinates(pX, pY);
        this.setText(pText);
    }

    public Text(String pFontPath, float pX, float pY, int pFontSize, String pText, Color pColor) {
        initLayout();
        generateText(pFontPath, pFontSize, pColor, false);
        this.setCoordinates(pX, pY);
        this.setText(pText);
    }

    public Text(String pFontPath, float pX, float pY, int pFontSize, String pText, boolean pShadow, Color pColor) {
        initLayout();
        generateText(pFontPath, pFontSize, pColor, pShadow);
        this.setCoordinates(pX, pY);
        this.setText(pText);
    }

    //Getters y Setters

    public BitmapFont getFont() {
        return font;
    }

    private GlyphLayout getGlayout() {
        return glayout;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getText() {
        return text;
    }

    public float getWidth() {
        return this.getGlayout().width;
    }

    public float getHeight() {
        return this.getGlayout().height;
    }


    public int getFontSize() {
        return fontSize;
    }

    public void setFont(BitmapFont _Font) {
        this.font = _Font;
    }

    public void setGlayout(GlyphLayout _Glayout) {
        this.glayout = _Glayout;
    }

    public void setX(float _X) {
        this.x = _X;
    }

    public void setY(float _Y) {
        this.y = _Y;
    }

    public void setFontSize(int _FontSize) {
        this.fontSize = _FontSize;
    }

    public void setText(String pText) {
        this.text = pText;
        this.glayout.setText(this.font, pText);
    }

    public void setCoordinates(float pX, float pY) {
        this.setX(pX);
        this.setY(pY);
    }

    public void setColor(Color pColor) {
        this.getFont().setColor(pColor);
    }

    //Funciones Publicas
    public void draw() {
        this.font.draw(Render._Batch, this.getText(), this.getX(), this.getY());
    }

    public void centerTextScreen() {
        float w = (Resources.HEIGHT / 2) - (this.getHeight() / 2);
        float h = (Resources.WIDTH / 2) - (this.getWidth() / 2);
        this.setCoordinates(w, h);
    }

    private void generateText(String pFontPath, int pFontSize, Color pColor, boolean pShadow) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(pFontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = pFontSize;
        parameter.color = pColor;
        if (pShadow) {
            parameter.shadowOffsetX = 1;
            parameter.shadowOffsetY = 1;
            parameter.shadowColor = Color.BLACK;
        }
        this.setFontSize(pFontSize);
        this.font = generator.generateFont(parameter);


    }

    private void initLayout() {
        this.setGlayout(new GlyphLayout());
    }

}
