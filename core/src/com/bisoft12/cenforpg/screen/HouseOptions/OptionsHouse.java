package com.bisoft12.cenforpg.screen.HouseOptions;
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

public class OptionsHouse implements Disposable {

    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private boolean timeUp;
    private float timeCount;
    private static Integer score;

    private Label time;
    private Table table;

    public OptionsHouse(SpriteBatch sb) {

        viewport = new FitViewport(Resources.WIDTH, Resources.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        table = new Table();
        table.top();
        table.setFillParent(true);

        time = new Label("PASO DEL TIEMPO:", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(time).expandX().padTop(25);
        stage.addActor(table);
    }


    @Override
    public void dispose() {
        stage.dispose();
    }

}