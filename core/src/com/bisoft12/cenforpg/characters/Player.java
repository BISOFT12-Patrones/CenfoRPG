package com.bisoft12.cenforpg.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class Player extends Sprite {

    private float X;
    private float Y;
    private int SPEED = 2;
    private Texture texture;
    private World world;
    private Body b2Body;

    public Player(String pTexture, float pX, float pY, World pWorld) {
        this.texture = new Texture(pTexture);
        this.X = pX;
        this.Y = pY;
        this.world = pWorld;
        definePlayer();
    }

    /**
     * Getters y setters
     **/

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public float getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    @Override
    public float getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Body getB2Body() {
        return b2Body;
    }

    /**
     * Metodos publicos
     **/

    public void move(String pDirection) {
        if (pDirection.equals("up")){
            this.Y += SPEED;
        }
        if (pDirection.equals("down")){
            this.Y -= SPEED;
        }
        if (pDirection.equals("left")){
            this.X -= SPEED;
        }
        if (pDirection.equals("right")){
            this.X += SPEED;
        }
    }

    public void update(){
        world.step(1 / 60f, 6, 2);
    }

    /**
     * Metodos privados
     **/

    private void definePlayer() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(this.X, this.Y);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2Body = world.createBody(bdef);

        CircleShape shape = new CircleShape();
        shape.setRadius(15f);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;

        b2Body.createFixture(fdef);
        shape.dispose();
    }

}
