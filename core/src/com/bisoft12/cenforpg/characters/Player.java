package com.bisoft12.cenforpg.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.bisoft12.cenforpg.io.Inputs;

public class Player extends Sprite {

    //para e movemiento del jugador
    private Vector2 velocity = new Vector2();
    private float speed = 4;

    private Texture _Texture;
    private Sprite _Sprite;
    private static final float ALTO_DEF = 128, ANCHO_DEF = 128;

    private TiledMapTileLayer collisionLayer;

    private Inputs input;


    //Constructores
    public Player(String pSourceTexture) {
        createCharacter(pSourceTexture, this.ALTO_DEF, this.ANCHO_DEF, 0, 0);
    }

    public Player(String pSourceTexture, float pHeight, float pWidth) {
        createCharacter(pSourceTexture, pHeight, pWidth, 0, 0);
    }

    public Player(String pSourceTexture, float pHeight, float pWidth, int pX, int pY) {
        createCharacter(pSourceTexture, pHeight, pWidth, pX, pY);
        input = new Inputs();
    }

    public Player(String pSourceTexture, int pX, int pY) {
        createCharacter(pSourceTexture, this.ALTO_DEF, this.ANCHO_DEF, pX, pY);
    }

    //GetSet
    public float getX() {
        return this.get_Sprite().getX();
    }

    public float getY() {
        return this.get_Sprite().getY();
    }

    public float getWidth() {
        return this.get_Sprite().getWidth();
    }

    public float getHeight() {
        return this.get_Sprite().getHeight();
    }

    public Texture get_Texture() {
        return _Texture;
    }

    public Sprite get_Sprite() {
        return _Sprite;
    }

    public void set_Texture(Texture _Texture) {
        this._Texture = _Texture;
    }

    public void set_Sprite(Sprite _Sprite) {
        this._Sprite = _Sprite;
    }

    public void setX(float pX) {
        this.get_Sprite().setX(pX);
    }

    public void setY(float pY) {
        this.get_Sprite().setY(pY);
    }

    public void setSize(float pH, float pW) {
        this.get_Sprite().setSize(pW, pH);
    }

    //Funciones publicas

    public void draw(SpriteBatch pSp) {
        this.get_Sprite().draw(pSp);
    }

    public void tiledPlayer(TiledMapTileLayer collisionLayer) {
        this.collisionLayer = collisionLayer;
    }

    public void movement(String pCara) {
        switch (pCara) {
            case "up":
                velocity.y = speed;
                setY(getY() + velocity.y);

                break;
            case "down":
                velocity.y = -speed;
                setY(getY() + velocity.y);

                break;
            case "left":
                velocity.x = -speed;
                setX(getX() + velocity.x);
                break;
            case "right":
                velocity.x = speed;
                setX(getX() + velocity.x);
                break;
        }

    }
    //Funciones privadas

    private void createCharacter(String pSourceTexture, float pHeight, float pWidth, int pX, int pY) {
        this.set_Texture(new Texture(pSourceTexture));
        this.set_Sprite(new Sprite(this.get_Texture()));
        this.setX(pX);
        this.setY(pY);
        this.setSize(pHeight, pWidth);
    }

    @Override
    public void draw(Batch batch) {

        update(Gdx.graphics.getDeltaTime());

        super.draw(batch);
    }


    private void update(float pDelta) {
        //guardamos la posicion
        float oldX = getX(), oldY = getY(), tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
        boolean collisionX = false, collisionY = false;

        //Movimiento en x
        setX(getX() + velocity.x * pDelta);

        if (velocity.x < 0) {
            //alto izquierda
            collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() + getHeight() / tileHeight)).getTile().getProperties().containsKey("blocked");
            //medio izquierda
            if (!collisionX)
                collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() + getHeight() / 2)).getTile().getProperties().containsKey("blocked");
            //bajo izquierda
            if (!collisionX)
                collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / getHeight())).getTile().getProperties().containsKey("blocked");

        } else if (velocity.x > 0) {
            //alto derecha
            collisionX = collisionLayer.getCell((int) (getX() + getWidth() / tileWidth), (int) (getY() + getHeight() / tileHeight)).getTile().getProperties().containsKey("blocked");

            //medio derecha
            if (!collisionX)
                collisionX = collisionLayer.getCell((int) (getX() + getWidth() / tileWidth), (int) ((getY() + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");

            //bajo derecha
            if (!collisionX)
                collisionX = collisionLayer.getCell((int) (getX() + getWidth() / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
        }
        //Si colisiona en x
        if (collisionX) {
            setX(oldX);
            velocity.x = 0;
        }


        //Movimeinto en y
        setY(getY() + velocity.y * pDelta);

        if (velocity.y < 0) {
            //bajo izquierda
            collisionY = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");

            //bajo medio
            if (!collisionY)
                collisionY = collisionLayer.getCell((int) (getX() + getWidth() / 2), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");

            //bajo bajo
            if (!collisionY)
                collisionY = collisionLayer.getCell((int) (getX() + getWidth() / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");

        } else if (velocity.y > 0) {

            //alto izquierda
            collisionY = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() + getHeight() / tileHeight)).getTile().getProperties().containsKey("blocked");

            //alto medio
            if (!collisionY)
                collisionY = collisionLayer.getCell((int) ((getX() + getWidth()) / 2), (int) (getY() + getHeight() / tileHeight)).getTile().getProperties().containsKey("blocked");

            //alto derecha
            if (!collisionY)
                collisionY = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() + getHeight() / tileHeight)).getTile().getProperties().containsKey("blocked");

        }
        //si colisiona en y
        if (collisionY) {
            setY(oldY);
            velocity.y = 0;
        }

    }


}
