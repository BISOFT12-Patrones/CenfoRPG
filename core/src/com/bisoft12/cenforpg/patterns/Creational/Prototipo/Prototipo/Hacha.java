package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

public class Hacha extends Arma {
    public Hacha(int pId, String pInformacion, int pDano) {
        this.setId(pId);
        this.setNombre("Hacha");
        this.setInformacion(pInformacion);
        this.setDano(pDano);
    }

    @Override
    public Arma clone() {
        return new Hacha(this.getId(), this.getInformacion(), this.getDano());
    }
}
