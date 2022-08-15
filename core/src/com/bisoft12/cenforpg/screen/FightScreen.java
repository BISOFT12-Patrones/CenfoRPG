package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.patterns.Comportamiento.Main.Gestor_Memento;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Fight.FightClass;
import com.bisoft12.cenforpg.screen.BattleOptions.OptionsBattle;
import com.bisoft12.cenforpg.utils.Pantalla;
import com.bisoft12.cenforpg.utils.Render;

public class FightScreen implements Screen {
    //Para el jugador
    private Render render;
    private Inputs input;
    private Pantalla screen;
    private Player player;
    //Para cargar las texturas del jugador movible
    private TextureAtlas atlas;

    private FightClass fightClass = new FightClass();
    private OptionsBattle optionsBattle;
    ////////Gestor Memento////////////////
    private Gestor_Memento gMemento = new Gestor_Memento();

    /////////////////////////////////////

    public FightScreen() {
        input = new Inputs();
        screen = new Pantalla("maps/map/FigthScreen_map.tmx");

        atlas = new TextureAtlas("characters/mainCharacters/Pack/playerAssets.pack");
        player = new Player(atlas, 284, 146, this.screen.getWorld());
        fightClass.datosPlayer();

        optionsBattle = new OptionsBattle(render.Batch);

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        render.clearScreen();


        screen.update(delta);
        player.update(delta);

        render.Batch.setProjectionMatrix(optionsBattle.stage.getCamera().combined);
        optionsBattle.stage.draw();
        optionsBattle.update(delta);

        //Carga imagen de muñeco

        render.Batch.setProjectionMatrix(screen.getCAMERA().combined);
        render.Batch.begin();
        player.draw(render.Batch);

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
    }

    @Override
    public void dispose() {
        //Limpiamos cuando se salga de la pantalla
        screen.isDispose(true);
        atlas.dispose();
    }
}
