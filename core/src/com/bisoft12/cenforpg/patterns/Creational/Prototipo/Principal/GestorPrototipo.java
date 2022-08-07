package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Principal;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo.Espada;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo.Flecha;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo.Hacha;
import com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo.Varita;

import java.util.ArrayList;

public class GestorPrototipo {
    private static ArrayList<Arma> arrArmas = new ArrayList();
    private int idEspada;
    private int idFlecha;
    private int idHacha;
    private int idVarita;

    private Arma prototipoEspada;
    private Arma prototipoFlecha;
    private Arma prototipoHacha;
    private Arma prototipoVarita;

    GestorPrototipo(int pIdEspada, int pIdFlecha, int pIdHacha, int pIdVarita) {
        this.idEspada = pIdEspada;
        this.idFlecha = pIdFlecha;
        this.idHacha = pIdHacha;
        this.idVarita = pIdVarita;
        this.prototipoEspada = new Espada(idEspada, "Espada que ataca, unicamente el caballero la usara", 1, 2, 3);
        this.prototipoFlecha = new Flecha(idFlecha, "Flecha que ataca, unicamente el arquero la usara", 1, 2, 3);
        this.prototipoHacha = new Hacha(idHacha, "Hacha que ataca, unicamente el caballero la usara", 1, 2, 3);
        this.prototipoVarita = new Varita(idVarita, "Varita que tiene poderes distintos, unicamente el mago la usara", 1, 2, 3);
    }

    public void nuevaArma(int pNum) {
        int mid = 0;
        if (pNum == 0) {
            arrArmas.add(this.prototipoEspada.clone());
            ++this.idEspada;
            mid = this.idEspada;
        }

        if (pNum == 1) {
            arrArmas.add(this.prototipoFlecha.clone());
            ++this.idFlecha;
            mid = this.idFlecha;
        }

        if (pNum == 2) {
            arrArmas.add(this.prototipoHacha.clone());
            ++this.idHacha;
            mid = this.idHacha;
        }

        if (pNum == 3) {
            arrArmas.add(this.prototipoVarita.clone());
            ++this.idVarita;
            mid = this.idVarita;
        }
        updateCloneArma(pNum, mid);
    }

    private static void updateCloneArma(int pId, int pMid) {
        Arma aa = arrArmas.get(pId);
        aa.setTipo(Helper.definirArma(Helper.randomizer()));

    }

    public String obtenerDatos() {
        String datos = "";
        for (Arma a : arrArmas) {
            datos = datos + a.getNombre() + " " + a.getTipo().getNombre() + "\n";
        }
        return datos;
    }

}
