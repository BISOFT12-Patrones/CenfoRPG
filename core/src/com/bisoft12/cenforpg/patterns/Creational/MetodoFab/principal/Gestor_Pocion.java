package com.bisoft12.cenforpg.patterns.Creational.MetodoFab.principal;

import com.bisoft12.cenforpg.patterns.Creational.MetodoFab.creador.MetodoFab_Pocion;
import com.bisoft12.cenforpg.patterns.Creational.MetodoFab.creador_concreto.Fab_Pociones;

import java.util.Random;

/************************************************************
 * Patrón: Método Fábrica
 * Función: creación de las pociones mágicas
 * Participantes:
 * Creador (MetodoFab_Pocion)
 * Creador Concreto (Fab_Pociones)
 * Gestor (Gestor_Pocion)
 * Producto (Pocion)
 * Producto Concreto (Pocion_Curativa, Pocion_Hechizo)
 ************************************************************/

public class Gestor_Pocion {
    private static MetodoFab_Pocion gFabrica;
    public Gestor_Pocion() {  gFabrica = new Fab_Pociones(); }

    public static int randomPelea() {
        int pick = 0;
        Random rand = new Random();
        pick = rand.nextInt((2 - 1) + 2) + 2;
        return pick;
    }

    public static int randomCuracion() {
        int min = 3;
        int max = 4;
        int pick = 0;
        Random rand = new Random();
        pick = rand.nextInt(max-min) + min;
        return pick;
    }

    public void escogerPocion(int pId) {
        int tipo = 0;
        if (pId == 0){
            tipo = randomPelea();
            nuevaPocion(tipo);
            }else{
            if(pId == 1){
                tipo = randomCuracion();
                nuevaPocion(tipo);
            }
        }
    }
    public void nuevaPocion (int pTipo) {
    gFabrica.crearPocion(pTipo);
    }



}//
