package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class SoploHielo extends TipoArma {
    private int id;

    public SoploHielo() {
        this.setNombre("Soplo Hielo");
        this.setAtaque(0);
        this.setDefensa(0);
        this.setMagia(0);
        this.setPrecio(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
