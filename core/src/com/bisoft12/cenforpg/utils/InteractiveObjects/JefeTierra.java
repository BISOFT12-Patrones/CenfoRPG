package com.bisoft12.cenforpg.utils.InteractiveObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.patterns.Comportamiento.Observador.Main.GestorObservador;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.screen.FightScreen;
import com.bisoft12.cenforpg.utils.InteractiveTileObject;
import com.bisoft12.cenforpg.utils.Resources;

public class JefeTierra extends InteractiveTileObject {

    public JefeTierra(World pWorld, TiledMap pMap, Rectangle pBounds) {
        super(pWorld, pMap, pBounds);

        FIXTURE.setUserData(this);
    }


    @Override
    public void onHit() {
        Gdx.app.log("BossZone", "Collision");
        GestorObservador gestor = new GestorObservador();
        gestor.nuevaBatalla("Batalla");
        gestor.NuevoObservador("Battle", "Batalla");
        FabricaCharacter gestorCharacter = new FabricaCharacter();

        gestorCharacter.getCharacter().setJefe(true);
        gestorCharacter.getCharacter().setFight(true);
        Resources.MAIN.setScreen(new FightScreen());

    }
}
