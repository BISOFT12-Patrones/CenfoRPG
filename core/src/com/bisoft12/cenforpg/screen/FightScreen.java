package com.bisoft12.cenforpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.bisoft12.cenforpg.characters.Player;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Fight.FightClass;
import com.bisoft12.cenforpg.patterns.Structural.Composite.components.NPC;
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
    private FabricaCharacter gestorCharacte = new FabricaCharacter();
    private NPC enemy = new NPC(gestorCharacte.getCharacter().getLevel());

    private Sprite enemigoSprite;

    public FightScreen() {
        input = new Inputs();
        screen = new Pantalla("maps/map/FigthScreen_map.tmx");

        atlas = new TextureAtlas("characters/mainCharacters/Pack/playerAssets.pack");
        player = new Player(atlas, 284, 146, this.screen.getWorld());
        fightClass.datosPlayer();
        optionsBattle = new OptionsBattle(render.Batch);

        enemigoSprite = enemy.getSprite();

    }

    @Override
    public void show() {
        optionsBattle.generatePoderes();
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        render.clearScreen();

        screen.update(delta);
        player.update(delta);

        render.Batch.begin();

        enemigoSprite.draw(render.Batch);
        render.Batch.end();
        render.Batch.setProjectionMatrix(optionsBattle.stage.getCamera().combined);

        optionsBattle.stage.draw();
        optionsBattle.update(delta);
        //Carga imagen de muñeco
        optionsBattle.render(delta);
        render.Batch.setProjectionMatrix(screen.getCAMERA().combined);
        render.Batch.begin();
        player.draw(render.Batch);
        render.Batch.end();
        System.out.println(enemy.getDefense());

        validateKeys();
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

    private void validateKeys() {
        try {
            int mTime = 200;
            if (this.input.isDown()) {
                optionsBattle.setActual(optionsBattle.getActual() + 1);

                if (optionsBattle.getActual() > optionsBattle.getArmas().size() - 1)
                    optionsBattle.setActual(0);
                optionsBattle.changeOptionColor(optionsBattle.getActual());
                Thread.sleep(mTime);
            }
            if (this.input.isUp()) {
                optionsBattle.setActual(optionsBattle.getActual() - 1);
                if (optionsBattle.getActual() < 0)
                    optionsBattle.setActual(1);
                Thread.sleep(mTime);
                optionsBattle.changeOptionColor(optionsBattle.getActual());
            }
            if (this.input.isEnter()) {
                Thread.sleep(mTime);
                optionsBattle.executeAction();
            }
        } catch (InterruptedException e) {
            Render.print(e.toString());
        }
    }

}
