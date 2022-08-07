package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

public class Espada extends Arma {

    public Espada(int pId, String pInformacion, int pDano) {
        this.setId(pId);
        this.setNombre("Espada");
        this.setInformacion(pInformacion);
        this.setDano(pDano);
    }


    @Override
    public Arma clone() {
        return new Espada(this.getId(), this.getInformacion(), this.getDano());
    }
}
