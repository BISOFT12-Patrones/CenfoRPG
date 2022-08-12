package com.bisoft12.cenforpg.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;

public class Player extends Sprite {

    private float X;
    private float Y;
    private int SPEED = 2;
    //private Texture texture;
    private World world;
    private Body b2Body;


    private enum State {STANDINGup, STANDINGdown, STANDINGleft, STANDINGright, RUNNINGup, RUNNINGdown, RUNNINGleft, RUNNINGright}

    ;

    private State currentState;
    private State previousState;

    //Animacion para el personaje
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> playerRunR; // Right
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> playerRunL; // Left
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> playerRunU; // Up
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> playerRunD; // Down

    private float stateTimer;

    private TextureRegion playerStand;

    private FabricaCharacter gestorCharacte = new FabricaCharacter();

    //Player stats
    private static int HP = 100;
    private static int EXP = 100;
    private static int LEVEL = EXP / 100;

    public static int getHP() {
        return HP;
    }

    public static void setHP(int HP) {
        Player.HP = HP;
    }

    public static int getEXP() {
        return EXP;
    }

    public static void setEXP(int EXP) {
        Player.EXP = EXP;
        LEVEL = Player.EXP / 100;
    }

    public static int getLEVEL() {
        return LEVEL;
    }

    public static void setLEVEL(int LEVEL) {
        Player.LEVEL = LEVEL;
    }

    public Player(TextureAtlas pAtlas, float pX, float pY, World pWorld) {

        super(pAtlas.findRegion("ArqueroSprites"));

        this.X = pX;
        this.Y = pY;
        this.world = pWorld;

        ///Inicia Animacion personaje
        currentState = State.STANDINGdown;
        previousState = State.STANDINGdown;
        stateTimer = 0;

        int y = 0;
        if (gestorCharacte.getCharacter().getTipeCharacter().equals("Mago"))
            y = 1;
        else if (gestorCharacte.getCharacter().getTipeCharacter().equals("Arquero"))
            y = 69;
        else if (gestorCharacte.getCharacter().getTipeCharacter().equals("Caballero"))
            y = 35;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        //Para la animacion del personaje
        //Derecha
        for (int i = 3; i < 6; i++) {
            frames.add(new TextureRegion(getTexture(), i * 32, y, 32, 32));
        }
        playerRunR = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(0.1f, frames);
        frames.clear();
        //Abajo
        for (int i = 0; i < 3; i++) {
            frames.add(new TextureRegion(getTexture(), i * 32, y, 32, 32));
        }
        playerRunD = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(0.1f, frames);
        frames.clear();
        //Arriba
        for (int i = 6; i < 9; i++) {
            frames.add(new TextureRegion(getTexture(), i * 32, y, 32, 32));
        }
        playerRunU = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(0.1f, frames);
        frames.clear();
        //Izquierda
        for (int i = 9; i < 12; i++) {
            frames.add(new TextureRegion(getTexture(), i * 32, y, 32, 32));
        }
        playerRunL = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(0.1f, frames);
        frames.clear();

        //Fin de animacion

        definePlayer();

        setBounds(0, 0, 32, 32);
        playerStand = new TextureRegion(this.getTexture(), 0, y, 32, 32);

        setRegion(playerStand); //Esto lo que hace es ya asociar al body
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
            currentState = State.RUNNINGup;
        }
        if (pDirection.equals("down")) {
            b2Body.setLinearVelocity(0, -100);
            currentState = State.RUNNINGdown;
        }
        if (pDirection.equals("left")) {
            b2Body.setLinearVelocity(-100, 0);
            currentState = State.RUNNINGleft;
        }
        if (pDirection.equals("right")) {
            b2Body.setLinearVelocity(100, 0);
            currentState = State.RUNNINGright;
        }
        previousState = currentState;

        if (pDirection.equals("none")) {
            b2Body.setLinearVelocity(0, 0);
            currentState = getState();
        }
    }

    public void update(float delta) {
        setPosition(getX() - getWidth() / 2, getY() - getHeight() / 2); //Para que se este en el mismo lugar que el cuerpo y la imagen
        setRegion(getFrame(delta));
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
        shape.setRadius(8f);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;

        b2Body.createFixture(fdef).setUserData("player");
        shape.dispose();

    }

    private TextureRegion getFrame(float delta) {

        TextureRegion region;
        switch (currentState) {
            case RUNNINGup:
                region = playerRunU.getKeyFrame(stateTimer, true);
                break;
            case RUNNINGdown:
                region = playerRunD.getKeyFrame(stateTimer, true);
                break;
            case RUNNINGleft:
                region = playerRunL.getKeyFrame(stateTimer, true);
                break;
            case RUNNINGright:
                region = playerRunR.getKeyFrame(stateTimer, true);
                break;
            default:
                region = playerStand;
                break;
        }
        stateTimer = currentState == previousState ? stateTimer + delta : 0;
        return region;

    }

    private State getState() {
        if (previousState.equals("RUNNINGup"))
            return State.STANDINGup;
        else if (previousState.equals("RUNNINGdown"))
            return State.STANDINGdown;
        else if (previousState.equals("RUNNINGleft"))
            return State.STANDINGleft;
        else
            return State.STANDINGright;
    }


}
