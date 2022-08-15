package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class Fundir extends TipoArma {

    private int id;

    public Fundir() {
        this.setNombre("Fundir");
        this.setAtaque(75);
        this.setDefensa(0);
        this.setMagia(70);
        this.setPrecio(450);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
