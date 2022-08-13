package com.bisoft12.cenforpg.screen.BattleOptions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bisoft12.cenforpg.elements.Images;
import com.bisoft12.cenforpg.elements.Text;
import com.bisoft12.cenforpg.io.Inputs;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Fight.FightClass;
import com.bisoft12.cenforpg.patterns.Structural.Composite.components.NPC;
import com.bisoft12.cenforpg.screen.CityScreen;
import com.bisoft12.cenforpg.screen.MerchantMenu.Merchant_MenuEspada;
import com.bisoft12.cenforpg.screen.MerchantMenu.Merchant_MenuFlecha;
import com.bisoft12.cenforpg.screen.TerrainMonster;
import com.bisoft12.cenforpg.utils.Render;
import com.bisoft12.cenforpg.utils.Resources;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


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

    //Para ememigos
    private Label vidaEnemy;
    private Label vidaEnemyTot;

    private Label ataqueEnemy;
    private Label ataqueaEnemyTot;

    private Table table = new Table();
    private Table tableEnemy = new Table();
    private FabricaCharacter gestorCharacter = new FabricaCharacter();
    Character player = gestorCharacter.getCharacter();
    private FightClass fight = new FightClass();

    private NPC enemy = new NPC(player.getLevel());

    //Para el menu de poderes
    private Inputs input;
    private com.bisoft12.cenforpg.elements.Text gameName;
    private ArrayList<Text> armas;
    private HashMap<Integer, String> armasHash = new HashMap<Integer, String>();
    private int cantidadArmas = 0;
    private float alpha, sum;
    private int actual = 0;
    ShapeRenderer border;
    private Render render = new Render();

    public OptionsBattle(SpriteBatch sb) {
        //define our tracking variables

        //setup the HUD viewport using a new camera seperate from our gamecam
        //define our stage using that viewport and our games spritebatch
        viewport = new FitViewport(Resources.WIDTH, Resources.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);


        //Para mostrar las opciones
        this.sum = 0.0008F;
        this.alpha = 0;
        this.armas = new ArrayList<Text>();
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.GAME_FONT, (Resources.WIDTH / 2) / 2, Resources.HEIGHT - 100, 25, "Selecciona un arma para atacar");

    }

    public NPC getEnemy() {
        return enemy;
    }

    public void update(float dt) {
        vidaTot = new Label(String.format("%01d", fight.getVidaJugador()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        defensaTot = new Label(String.format("%01d", player.getDefense()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        ataqueTot = new Label(String.format("%01d", player.getAttack()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        vidaEnemyTot = new Label(String.format("%01d", enemy.getDefense()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        ataqueaEnemyTot = new Label(String.format("%01d", enemy.getAttack()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    }

    public void mostrarPlayerStat() {
        table.clear();
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
        table.add(vida).expandX().padTop(10);
        table.add(defensa).expandX().padTop(10);
        table.add(ataque).expandX().padTop(10);
        //add a second row to our table
        table.row();
        table.add(vidaTot).expandX();
        table.add(defensaTot).expandX();
        table.add(ataqueTot).expandX();

        //add our table to the stage
        stage.addActor(table);
        mostrarEnemyStat();
    }

    public void mostrarEnemyStat() {
        //define a table used to organize our hud's labels
        tableEnemy.clear();
        //Top-Align table
        tableEnemy.bottom();
        //make the table fill the entire stage
        tableEnemy.setFillParent(true);

        //define our labels using the String, and a Label style consisting of a font and color
        vidaEnemyTot = new Label(String.format("%01d", enemy.getDefense()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        vidaEnemy = new Label("Vida Enemigo", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //define our labels using the String, and a Label style consisting of a font and color
        ataqueaEnemyTot = new Label(String.format("%01d", enemy.getAttack()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        ataqueEnemy = new Label("Ataque Enemigo", new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        //add our labels to our table, padding the top, and giving them all equal width with expandX
        tableEnemy.add(vidaEnemy).expandX().padBottom(10);
        tableEnemy.add(ataqueEnemy).expandX().padBottom(10);
        //add a second row to our table
        tableEnemy.row();
        tableEnemy.add(vidaEnemyTot).expandX();
        tableEnemy.add(ataqueaEnemyTot).expandX();


        //add our table to the stage
        stage.addActor(tableEnemy);
    }

    public void render(float v) {
        render.Batch.begin();
        this.gameName.draw();
        for (Text mTemp : this.armas) {
            mTemp.draw();
        }

        render.Batch.end();
        mostrarEnemyStat();
        mostrarPlayerStat();
    }

    public void generatePoderes() {
        int mFontSize = 15;
        float mNextY = 0;
        int mRest = 25;
        this.gameName.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        if (player.getArmas().size() > 0) {
            for (int i = 0; i < player.getArmas().size(); i++) {
                if (player.getArmas().get(i).getNombre().equals("Espada") || player.getArmas().get(i).getNombre().equals("Flecha") || player.getArmas().get(i).getNombre().equals("Hacha") || player.getArmas().get(i).getNombre().equals("Varita")) {
                    cantidadArmas++;
                    this.armas.add(new Text(player.getArmas().get(i).getTipo().getNombre() + " - " + player.getArmas().get(i).getTipo().getAtaque(), mFontSize, Resources.GAME_FONT));
                    this.armasHash.put(cantidadArmas, player.getArmas().get(i).getTipo().getNombre());
                }
            }
            if (armas.isEmpty()) {
                this.armas.add(new Text("Puño", mFontSize, Resources.GAME_FONT));
                this.armasHash.put(cantidadArmas, "Puño");
                cantidadArmas++;
                this.armas.add(new Text("Cahetada", mFontSize, Resources.GAME_FONT));
                this.armasHash.put(cantidadArmas, "Puño");
                cantidadArmas++;
            }

        } else {
            this.armas.add(new Text("Puño", mFontSize, Resources.GAME_FONT));
            this.armasHash.put(cantidadArmas, "Puño");
            cantidadArmas++;
        }

        this.armas.get(0).setCoordinates((Resources.WIDTH / 2) / 2, Resources.HEIGHT - 120);
        mNextY = this.armas.get(0).getY();
        for (Text mTemp : this.armas) {
            mTemp.centerTextScreen();
            mNextY -= mRest;
            mTemp.setY(mNextY);
        }
        changeOptionColor(0);
    }

    public void changeOptionColor(int pId) {
        for (Text mTemp : this.armas) {
            mTemp.setColor(com.badlogic.gdx.graphics.Color.WHITE);
            if (pId >= 0) {
                this.armas.get(pId).setColor(Color.CHARTREUSE);
                this.actual = pId;
            }
        }
    }


    public void executeAction() throws InterruptedException {
        System.out.println("CLICK EN EJECUCION");
        for (int i = 0; i < player.getArmas().size(); i++) {
            System.out.println(player.getArmas().get(i).getTipo().getNombre());
            if (player.getArmas().get(i).getTipo().getNombre().equals(armasHash.get(this.actual + 1))) {
                fight.opcionPeleaJugador(player.getArmas().get(i).getAtaque(), enemy);
            }
        }

    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public ArrayList<Text> getArmas() {
        return armas;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}