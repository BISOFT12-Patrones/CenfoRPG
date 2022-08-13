package com.bisoft12.cenforpg.screen.BattleOptions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Fight.FightClass;
import com.bisoft12.cenforpg.utils.Resources;


public class OptionsBattle implements Disposable {

    //Scene2D.ui Stage and its own Viewport for HUD
    public Stage stage;
    private Viewport viewport;

    //Mario score/time Tracking Variables
    private Integer worldTimer;
    private boolean timeUp; // true when the world timer reaches 0
    private float timeCount;
    private static Integer score;

    //Scene2D widgets
    private Label vida;
    private Label vidaTot;
    private Label ataque;
    private Label ataqueTot;
    private Label defensa;
    private Label defensaTot;

    private Table table;
    private FabricaCharacter gestorCharacter = new FabricaCharacter();
    Character player = gestorCharacter.getCharacter();
    private FightClass fight = new FightClass();



    public OptionsBattle(SpriteBatch sb) {
        //define our tracking variables


        //setup the HUD viewport using a new camera seperate from our gamecam
        //define our stage using that viewport and our games spritebatch
        viewport = new FitViewport(Resources.WIDTH, Resources.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        //define a table used to organize our hud's labels
        table = new Table();
        //Top-Align table
        table.top();
        //make the table fill the entire stage
        table.setFillParent(true);

        //define our labels using the String, and a Label style consisting of a font and color
        vidaTot = new Label(String.format("%01d", fight.getVidaJugador()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        vida = new Label("VIDA", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //define our labels using the String, and a Label style consisting of a font and color
        defensaTot = new Label(String.format("%01d", player.getDefense()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        defensa = new Label("DEFENSA", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        ataque = new Label("ATAQUE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        //define our labels using the String, and a Label style consisting of a font and color
        ataqueTot = new Label(String.format("%01d", player.getAttack()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        //add our labels to our table, padding the top, and giving them all equal width with expandX
        table.add(vida).expandX().padTop(5);
        table.add(defensa).expandX().padTop(5);
        table.add(ataque).expandX().padTop(5);
        //add a second row to our table
        table.row();
        table.add(vidaTot).expandX();
        table.add(defensaTot).expandX();
        table.add(ataqueTot).expandX();

        //add our table to the stage
        stage.addActor(table);
        mostrarPoderes();

    }

    public void update(float dt) {
        fight.opcionPelea();
        vidaTot = new Label(String.format("%01d", fight.getVidaJugador()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        defensaTot = new Label(String.format("%01d", player.getDefense()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        ataqueTot = new Label(String.format("%01d", player.getAttack()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    }

    public void mostrarPoderes(){
        table.row();
        table.row();

        //define our labels using the String, and a Label style consisting of a font and color
       Label armas = new Label("Habilidades", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //add our labels to our table, padding the top, and giving them all equal width with expandX
        table.add(armas).expandX().padLeft(5);

        //add a second row to our table
        table.row();

        fight.datosPlayer();
        for (int i=0;i < fight.getArmasFight().size() ;i++)
            table.add(fight.getArmasFight().get(i)).expandX();

        //add our table to the stage
        stage.addActor(table);
    }
    @Override
    public void dispose() {
        stage.dispose();
    }

}