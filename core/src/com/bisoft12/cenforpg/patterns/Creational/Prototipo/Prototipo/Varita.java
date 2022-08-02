package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

public class Varita extends Arma {

    public Varita(int pId, String pInformacion, int pDano, int pDefensa, int pMagia) {
        this.setId(pId);
        this.setNombre("Varita");
        this.setInformacion(pInformacion);
        this.setDano(pDano);
        this.setDefensa(pDefensa);
        this.setMagia(pMagia);
    }

    @Override
    public Arma clone() {
        return new Varita(this.getId(), this.getInformacion(), this.getDano(), this.getDefensa(), this.getMagia());
    }
}
