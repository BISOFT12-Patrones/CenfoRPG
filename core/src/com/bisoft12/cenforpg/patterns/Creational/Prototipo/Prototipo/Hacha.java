package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

public class Hacha extends Arma {
    public Hacha(int pId, String pInformacion, int pAtaque, int pDefensa, int pMagia) {
        this.setId(pId);
        this.setNombre("Hacha");
        this.setInformacion(pInformacion);
        this.setAtaque(pAtaque);
        this.setDefensa(pDefensa);
        this.setMagia(pMagia);
    }

    @Override
    public Arma clone() {
        return new Hacha(this.getId(), this.getInformacion(), this.getAtaque(), this.getDefensa(), this.getMagia());
    }
}
