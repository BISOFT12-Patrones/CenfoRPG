package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

public class Varita extends Arma {

    public Varita(int pId, String pInformacion, int pAtaque, int pDefensa, int pMagia) {
        this.setId(pId);
        this.setNombre("Varita");
        this.setInformacion(pInformacion);
        this.setAtaque(pAtaque);
        this.setDefensa(pDefensa);
        this.setMagia(pMagia);
    }

    @Override
    public Arma clone() {
        return new Varita(this.getId(), this.getInformacion(), this.getAtaque(), this.getDefensa(), this.getMagia());
    }
}
