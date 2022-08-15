package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.io.Dialogs;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.io.StatusText;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.Principal.GestorPrototipo;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;
import com.bisoft12.cenforpg.utils.WorldContactListener;

import java.util.Objects;


public class CityScreen implements Screen {

    //Para el jugador
    private Render render = new Render();
    private Inputs input;
    private Pantalla screen;
    private Player player;
    //Para cargar las texturas del jugador movible
    private TextureAtlas atlas;
    private Dialogs dialogs;
    private StatusText statusText;
    private FabricaCharacter gestor = new FabricaCharacter();
    private GestorPrototipo gestorArma = new GestorPrototipo(0, 1, 2, 3);



    public CityScreen() {

        input = new Inputs();
        screen = new Pantalla("maps/map/city.tmx");
        this.statusText = new StatusText();

        int[] layers = {1, 3};
        //Para los objetos interactivos
        screen.setHouse(true);
        screen.setHouseLayer(4);

        screen.setMerchant(true);
        screen.setMerchantLayer(2);

        screen.setTerrain(true);
        screen.setTerrainLayer(3);

        screen.setNpc(true);
        screen.setNpcLayer(5);

        screen.setKing(true);
        screen.setKingLayer(6);

        screen.Box2DMaplayers(layers);

        atlas = new TextureAtlas("characters/mainCharacters/Pack/playerAssets.pack");

        player = new Player(atlas, 417, 285, this.screen.getWorld());


        screen.getWorld().setContactListener(new WorldContactListener());

        this.dialogs = new Dialogs();
    }

    @Override
    public void show() {
        this.dialogs.getImage().setsize(150, Resources.WIDTH);
        this.dialogs.setCoordinates();
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        render.clearScreen();

        screen.update(delta);
        player.update(delta);


        //Carga imagen de muñeco

        render.Batch.setProjectionMatrix(screen.getCAMERA().combined);
        render.Batch.begin();
        this.statusText.draw();
        player.draw(render.Batch);
        if (!Objects.equals(Resources.dialog, "")) {
            this.dialogs.setText(Resources.dialog);
            this.dialogs.draw();
        }
        render.Batch.end();
        //---------------
        inputHandler();


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
        //Limpiamos cuando se salga de la pantalla
        screen.isDispose(true);

        atlas.dispose();
    }

    private void inputHandler() {
        if (input.isUp() || input.isDown() || input.isRight() || input.isLeft() || input.isEnter()) {
            if (input.isDown()) {
                player.move("down");
            }
            if (input.isLeft()) {
                player.move("left");
            }
            if (input.isRight()) {
                player.move("right");
            }
            if (input.isUp()) {
                player.move("up");
            }
            if (input.isEnter()) {
                Resources.dialog = "";
            }
        } else {
            player.move("none");
        }


    }


}//End of class
