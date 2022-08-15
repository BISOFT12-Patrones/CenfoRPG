package com.bisoft12.cenforpg.utils.InteractiveObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft12.cenforpg.patterns.Comportamiento.Main.GestorObservador;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.screen.FightScreen;
import com.bisoft12.cenforpg.utils.InteractiveTileObject;
import com.bisoft12.cenforpg.utils.Resources;

public class MonsterZones extends InteractiveTileObject {

    public MonsterZones(World pWorld, TiledMap pMap, Rectangle pBounds) {
        super(pWorld, pMap, pBounds);

        FIXTURE.setUserData(this);
    }


    @Override
    public void onHit() {
        Gdx.app.log("MonsterZone", "Collision");
        GestorObservador gestor = new GestorObservador();
        gestor.nuevaBatalla("Batalla");
        gestor.NuevoObservador("Battle", "Batalla");
        int numero = (int) (Math.random() * 10 + 1);
        FabricaCharacter gestorCharacter = new FabricaCharacter();
        if (!gestorCharacter.getCharacter().isFight()) {
            if (numero <= 3 || gestorCharacter.getCharacter().isDungeon()) {
                Resources.MAIN.setScreen(new FightScreen());
                gestorCharacter.getCharacter().setFight(true);
            }
        } else {
            gestorCharacter.getCharacter().setFight(false);
        }

    }
}
