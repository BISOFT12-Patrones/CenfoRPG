package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.io.Dialogs;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;
import com.bisoft12.cenforpg.utils.WorldContactListener;

import java.util.Objects;

public class TerrainMonster implements Screen {


    //Para el jugador
    private Render render;
    private Inputs input;
    private Pantalla screen;
    private Player player;
    //Para cargar las texturas del jugador movible
    private TextureAtlas atlas;
    private Dialogs dialogs;

    public TerrainMonster() {
        input = new Inputs();
        screen = new Pantalla("maps/map/terrainMonster.tmx", 561, 950);
        this.dialogs = new Dialogs();

        //Para la creacion de box2D en los objetos del mapa
        int[] layers = {2, 4};
        //Puerta Dungeon
        screen.setDungeon(true);
        screen.setDungeonLayer(1);
        //Zonas peleas
        screen.setMonster(true);
        screen.setMonsterLayer(3);

        screen.setNpc(true);
        screen.setNpcLayer(5);


        screen.Box2DMaplayers(layers);
        atlas = new TextureAtlas("characters/mainCharacters/Pack/playerAssets.pack");

        player = new Player(atlas, 566.9954f, 1095.9785f, this.screen.getWorld());

        screen.getWorld().setContactListener(new WorldContactListener());

    }

    @Override
    public void show() {
        this.dialogs.getImage().setsize(150, Resources.WIDTH);
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
        player.draw(render.Batch);
        if (!Objects.equals(Resources.dialog, "")) {
            this.dialogs.setText(Resources.dialog);
            this.dialogs.draw();
        }
        render.Batch.end();
        //---------------
        inputHandler();
        screen.getCAMERA().position.x = player.getX();
        screen.getCAMERA().position.y = player.getY();
        this.dialogs.setCoordinates( (int)player.getX(), (int)player.getY());

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
            if(input.isEnter()){
                Resources.dialog = "";
            }
        } else {
            player.move("none");
        }

        // System.out.println(player.getX() +","+player.getY());
    }

}