package com.bisoft12.cenforpg.screen.HouseOptions;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto.Pelear;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Estado.concreto.Recuperar;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Fight.FightClass;
import com.bisoft12.cenforpg.utils.Resources;

public class OptionsHouse implements Disposable {
    public Stage stage;
    private Viewport viewport;
    private Label header;
    private Label timer;
    private Table table;

    public OptionsHouse(SpriteBatch sb) {
        viewport = new FitViewport(Resources.WIDTH, Resources.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        table = new Table();
        table.top();
        table.setFillParent(true);

        header = new Label("Recuperando...", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(header).expandX().padTop(50);
        stage.addActor(table);
    }

   @Override
    public void dispose() {
        stage.dispose();
    }

}//