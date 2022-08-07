package com.bisoft12.cenforpg.patterns.Creational.Prototipo.Prototipo;

import com.bisoft12.cenforpg.patterns.Creational.Prototipo.IPrototipo.Arma;

public class Flecha extends Arma {

    public Flecha(int pId, String pInformacion, int pDano) {
        this.setId(pId);
        this.setNombre("Flecha");
        this.setInformacion(pInformacion);
        this.setDano(pDano);
    }

    @Override
    public Arma clone() {
        return new Flecha(this.getId(), this.getInformacion(), this.getDano());
    }
}
