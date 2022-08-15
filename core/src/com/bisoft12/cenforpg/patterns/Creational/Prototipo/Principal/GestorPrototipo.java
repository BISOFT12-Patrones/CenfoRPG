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

    private static int contador = 0;

    public GestorPrototipo(int pIdEspada, int pIdFlecha, int pIdHacha, int pIdVarita) {
        this.idEspada = pIdEspada;
        this.idFlecha = pIdFlecha;
        this.idHacha = pIdHacha;
        this.idVarita = pIdVarita;
        this.prototipoEspada = new Espada(idEspada, "Espada que ataca, unicamente el caballero la usara", 1, 2, 3);
        this.prototipoFlecha = new Flecha(idFlecha, "Flecha que ataca, unicamente el arquero la usara", 1, 2, 3);
        this.prototipoHacha = new Hacha(idHacha, "Hacha que ataca, unicamente el caballero la usara", 1, 2, 3);
        this.prototipoVarita = new Varita(idVarita, "Varita que tiene poderes distintos, unicamente el mago la usara", 1, 2, 3);
    }

    public Arma nuevaArma(int pNum, int tipoArma) {
        if (pNum == 0) {
            arrArmas.add(this.prototipoEspada.clone());
            ++this.idEspada;
        }

        if (pNum == 1) {
            arrArmas.add(this.prototipoFlecha.clone());
            ++this.idFlecha;
        }

        if (pNum == 2) {
            arrArmas.add(this.prototipoHacha.clone());
            ++this.idHacha;
        }

        if (pNum == 3) {
            arrArmas.add(this.prototipoVarita.clone());
            ++this.idVarita;
        }

        return updateCloneArma(contador, tipoArma);
    }

    private static Arma updateCloneArma(int pId, int pTipoArma) {
        Arma aa = arrArmas.get(pId);
        aa.setTipo(Helper.definirArma(pTipoArma));
        contador++;
        return aa;
    }

    public String obtenerDatos() {
        String datos = "";
        for (Arma a : arrArmas) {
            datos = datos + a.getTipo().getNombre() + "\n" + " Ataque: " +
                    a.getTipo().getAtaque() + "\n" + " Defensa: " +
                    a.getTipo().getDefensa() + "\n" + " Magia: " +
                    a.getTipo().getMagia() + "\n" + " Precio: " + a.getTipo().getPrecio() + "\n";
        }
        return datos;
    }

}
