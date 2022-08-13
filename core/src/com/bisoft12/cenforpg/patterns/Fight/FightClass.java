package com.bisoft12.cenforpg.patterns.Fight;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;
import com.bisoft12.cenforpg.patterns.Structural.Composite.components.NPC;
import com.bisoft12.cenforpg.screen.CityScreen;
import com.bisoft12.cenforpg.screen.HouseScreen;
import com.bisoft12.cenforpg.screen.TerrainMonster;
import com.bisoft12.cenforpg.utils.InteractiveObjects.House;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class FightClass {

    private FabricaCharacter gestorCharater = new FabricaCharacter();
    private Character player = gestorCharater.getCharacter();

    private int vidaJugador = 100;

    public void datosPlayer() {
        Arma armas = null;
        if (player.getTipeCharacter().equals("Caballero")) {

        }
    }

    public void opcionPeleaJugador(int pAtaque, NPC pEnemy) throws InterruptedException {
        double ataqueArma = pAtaque / 150;
        int ataqueTot = (int) (player.getAttack() * ataqueArma);
        if (ataqueTot == 0)
            ataqueTot = player.getAttack() / 2;
        System.out.println("Ataque realizado " + ataqueTot);
        pEnemy.setDefense(ataqueTot);
        if (pEnemy.getDefense() < 0) {
            Thread.sleep(5000);
            Resources.MAIN.setScreen(new TerrainMonster());
        } else
            opcionPeleaEnemigo(pEnemy);
    }

    private void opcionPeleaEnemigo(NPC pEnemy) throws InterruptedException {

        double ataqueEnemigo = (pEnemy.getAttack() / player.getDefense()) * 45 / 2;
        vidaJugador -= ataqueEnemigo;
        if (vidaJugador < 0) {
            Thread.sleep(5000);
            Resources.MAIN.setScreen(new HouseScreen());
        }
    }

    public int getVidaJugador() {
        return vidaJugador;
    }

    public void setVidaJugador(int vidaJugador) {
        this.vidaJugador = vidaJugador;
    }


}


/*the plan
 * 1. si es mago, no pueden salir las opciones de ataque normal, solo ataque con poderes
 * 2. si es caballero, puede atacar normal(uso de su ataque) o ataque con poderes(habilidades)
 * 3. si es arquero, lo mismo que el caballero
 * 4. las stats de los otros dos personajes van a ser los mismos que el del jugador
 * ------------------
 * Para la inteligencia artificial
 * 1. los enemigos no se pueden curar
 * 2. los enemigos atacan a uno aleatoriamente
 * */