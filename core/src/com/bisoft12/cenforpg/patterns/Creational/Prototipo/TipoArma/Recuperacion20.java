package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class Recuperacion20 extends TipoArma {
    private int id;

    public Recuperacion20() {
        this.setNombre("Recuperacion 20%");
        this.setAtaque(0);
        this.setDefensa(0);
        this.setMagia(50);
        this.setPrecio(250);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
