package com.bisoft12.cenforpg.patterns.Fight;

import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

import java.util.ArrayList;

public class FightClass {

    private FabricaCharacter gestorCharater = new FabricaCharacter();
    private Character player = gestorCharater.getCharacter();

    private int vidaJugador = 100;
    private ArrayList<String> armasFight = new ArrayList<String>();

    public void datosPlayer(){
        Arma armas = null;
        if (player.getTipeCharacter().equals("Caballero")){
           for (int i=0;i < player.getArmas().size() ;i++){
               armas =player.getArmas().get(i);
               if(armas.getTipo().equals("Arma")){
                   armasFight.add(armas.getNombre());
               }
           }

        }


    }

    public void opcionPelea(){
        if (player.getTipeCharacter().equals("Mago")){
            //Aqui se pone el codigo para que se muestren las opciones de la batalla

        }else if(player.getTipeCharacter().equals("Caballero")){

        }else if (player.getTipeCharacter().equals("Arquero")){

        }
    }

    private void ejecucionDano(double pDano){

    }

    public int getVidaJugador() {
        return vidaJugador;
    }

    public void setVidaJugador(int vidaJugador) {
        this.vidaJugador = vidaJugador;
    }

    public ArrayList<String> getArmasFight() {
        return armasFight;
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