package com.bisoft12.cenforpg.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player extends Sprite {

    private float X;
    private float Y;
    private int SPEED = 2;
    private TextureRegion texture;
    private World world;
    private Body b2Body;



    public Player(String pTexture, float pX, float pY, World pWorld) {
        this.texture = new TextureRegion(new Texture(Gdx.files.internal(pTexture)));
        this.X = pX;
        this.Y = pY;
        this.world = pWorld;

        definePlayer();
    }

    /**
     * Getters y setters
     **/

    @Override
    public float getX() {
        return b2Body.getPosition().x;
    }

    @Override
    public float getY() {
        return b2Body.getPosition().y;
    }


    /**
     * Metodos publicos
     **/

    public void move(String pDirection) {
        if (pDirection.equals("up")) {
            b2Body.setLinearVelocity(0, 100);
        }
        if (pDirection.equals("down")) {
            b2Body.setLinearVelocity(0, -100);
        }
        if (pDirection.equals("left")) {
            b2Body.setLinearVelocity(-100, 0);
        }
        if (pDirection.equals("right")) {
            b2Body.setLinearVelocity(100, 0);
        }
        if (pDirection.equals("none")) {
            b2Body.setLinearVelocity(0, 0);

        }
    }

    public void update() {

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
        shape.setRadius(12f);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;

        b2Body.createFixture(fdef);
        shape.dispose();

    }

}
