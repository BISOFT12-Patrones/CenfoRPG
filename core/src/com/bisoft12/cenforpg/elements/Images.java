package com.bisoft12.cenforpg.elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bisoft12.cenforpg.utils.Render;

public class Images {
    private Texture texture;

    private Sprite sprite;

    //Constructores
    public Images(String pSource) {
        this.setTexture(new Texture(pSource));
        this.setSprite(new Sprite(this.getTexture()));
    }

    //GET & SET
    public Texture getTexture() {
        return texture;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float getX() {
        return this.getSprite().getX();
    }

    public float getY() {
        return this.getSprite().getY();
    }

    public float getHeight() {
        return this.getSprite().getHeight();
    }

    public float getWidth() {
        return this.getSprite().getWidth();
    }

    //Sets
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setX(float pX) {
        this.getSprite().setX(pX);
    }

    public void setY(float pY) {
        this.getSprite().setY(pY);
    }

    public void setsize(float pH, float pW) {
        this.getSprite().setSize(pW, pH);
    }

    public void setCoordinates(float pX, float pY) {
        this.setX(pX);
        this.setY(pY);
    }

    /*
     * Function: Set Alpha
     * Descripcion: Esta funcion permite ajustar la transparencia de nuestras
     * imagenes
     *@param     pAlpha[Float] es el valor de la transparencia
     *           puede estar dentro de un rango de 0 a 1
     * @return N/A
     * */
    public void setAlpha(float pAlpha) {
        this.getSprite().setAlpha(pAlpha);
    }

    //Public Functions
    public void draw() {
        this.getSprite().draw(Render._Batch);
    }

    public void dispose() {
        this.getTexture().dispose();
    }
}
