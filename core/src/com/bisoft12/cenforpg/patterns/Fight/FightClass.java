package com.bisoft12.cenforpg.patterns.Fight;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;
import com.bisoft12.cenforpg.patterns.Structural.Composite.components.NPC;

import com.bisoft12.cenforpg.screen.HouseScreen;
import com.bisoft12.cenforpg.screen.TerrainMonster;
import com.bisoft12.cenforpg.utils.Resources;

import java.util.ArrayList;

public class FightClass {

    private FabricaCharacter gestorCharater = new FabricaCharacter();
    private Character player = gestorCharater.getCharacter();

    private int vidaJugador = 100;
    private String mensaje = "";

    public void datosPlayer() {
        Arma armas = null;
        if (player.getTipeCharacter().equals("Caballero")) {

        }
    }

    public int opcionPeleaJugador(int pAtaque, NPC pEnemy) {

        int ataqueTot = (((player.getAttack() * 60) / 100) + pAtaque);
        if (ataqueTot <= 0)
            ataqueTot = player.getAttack();
        mensaje = "Ataque realizado del jugador: total" + ataqueTot + "\n" + "\n";
        pEnemy.setDefense(ataqueTot);
        if (pEnemy.getDefense() < 0) {
            if (player.isFeje()) {
                player.setJefe(false);
                jugadorGana();
                return 3;
            } else {
                player.setJefe(false);
                jugadorGana();
                return 1;
            }

        } else {
            return opcionPeleaEnemigo(pEnemy);
        }
    }

    private int opcionPeleaEnemigo(NPC pEnemy) {

        double ataqueEnemigo = (pEnemy.getAttack() - ((player.getDefense() * 30) / 100)) / 100;
        vidaJugador -= ataqueEnemigo;
        mensaje += "Ataque realizado del enemigo: total" + ataqueEnemigo;
        Resources.dialog = mensaje;

        if (vidaJugador < 0) {
            jugadorPierde();
            player.setJefe(false);
            player.setDungeon(false);
            return 2;
        }
        return 0;
    }

    public int getVidaJugador() {
        return vidaJugador;
    }

    public void setVidaJugador(int vidaJugador) {
        this.vidaJugador = vidaJugador;
    }

    private void jugadorGana() {
        int experiencia = (int) (Math.random() * (250 - 50 + 1) + 100);

        int monedas = (int) (Math.random() * (200 - 50 + 1) + 50);
        player.setExperience(experiencia);
        player.setCoin(monedas);
        Resources.dialog = "Jugador gano la batalla, premios: " + "\n" + "Experiencia: " + experiencia + " Monedas: " + monedas;

    }

    private void jugadorPierde() {
        Resources.dialog = "Jugador perdio la batalla";

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