package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class SoploHielo extends TipoArma {
    private int id;

    public SoploHielo() {
        this.setNombre("Soplo Hielo");
        this.setAtaque(40);
        this.setDefensa(15);
        this.setMagia(25);
        this.setPrecio(100);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
