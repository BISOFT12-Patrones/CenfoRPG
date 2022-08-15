package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class Recuperacion5 extends TipoArma {
    private int id;

    public Recuperacion5() {
        this.setNombre("Recuperacion 5%");
        this.setAtaque(0);
        this.setDefensa(0);
        this.setMagia(25);
        this.setPrecio(50);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
