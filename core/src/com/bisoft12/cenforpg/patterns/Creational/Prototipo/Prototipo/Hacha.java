package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

public class Hacha extends Arma {
    public Hacha(int pId, String pInformacion, int pDano, int pDefensa, int pMagia) {
        this.setId(pId);
        this.setNombre("Hacha");
        this.setInformacion(pInformacion);
        this.setDano(pDano);
        this.setDefensa(pDefensa);
        this.setMagia(pMagia);
    }

    @Override
    public Arma clone() {
        return new Hacha(this.getId(), this.getInformacion(), this.getDano(), this.getDefensa(), this.getMagia());
    }
}
