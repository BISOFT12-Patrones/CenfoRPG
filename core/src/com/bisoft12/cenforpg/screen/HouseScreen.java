package com.bisoft12.cenforpg.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Dialogs;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.patterns.Comportamiento.Main.Gestor_Estado;
import com.bisoft12.cenforpg.patterns.Comportamiento.Main.Gestor_Memento;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto.Pelear;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto.Recuperar;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.objeto.Casa;
import com.bisoft12.cenforpg.screen.BattleOptions.OptionsBattle;
import com.bisoft12.cenforpg.screen.HouseOptions.OptionsHouse;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;
import jdk.internal.org.jline.utils.ShutdownHooks;

import java.awt.*;
import java.util.Objects;

import static com.bisoft12.cenforpg.utils.Resources.DIALOGS_BACKGROUND;

public class HouseScreen implements Screen {
    //Para el jugador
    private Render render;
    private Inputs input;
    private Pantalla screen;
    private Player player;
    ////////////////////////
    private Gestor_Estado gEstado = new Gestor_Estado();
    private Gestor_Memento gMemento = new Gestor_Memento();
    ////////////////////////
    private OptionsHouse optionsHouse;

    //Para cargar las texturas del jugador movible
    private TextureAtlas atlas;

    public HouseScreen() {
        this.gEstado = new Gestor_Estado();
        input = new Inputs();
        screen = new Pantalla("maps/map/house.tmx");
        atlas = new TextureAtlas("characters/mainCharacters/Pack/playerAssets.pack");
        player = new Player(atlas, 284, 146, this.screen.getWorld());
        optionsHouse = new OptionsHouse(render.Batch);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
    render.clearScreen();
    screen.update(delta);
    player.update(delta);
    //Carga imagen de muñeco
    render.Batch.setProjectionMatrix(screen.getCAMERA().combined);
    optionsHouse.stage.draw();
    render.Batch.begin();
    player.draw(render.Batch);
    inputHandler();

    if (gEstado.Mostrar_Estado().equals("Pelear")) {
            gMemento.Restaurar_Memento();
            Resources.MAIN.setScreen(new CityScreen());
        } else {
            gEstado.Cambiar_Estado(1); //ID = Estado Recuperar
        }
        render.Batch.end();
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
        screen.dispose();
    }
    private void inputHandler() {
        //En este mapa no hace falta el movimiento del jugador
       /* if (input.isUp() || input.isDown() || input.isRight() || input.isLeft()) {
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
        } else {
            player.move("none");
        }*/

       //System.out.println(player.getX() +","+player.getY());
    }

}//