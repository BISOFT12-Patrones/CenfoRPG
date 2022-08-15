package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class GolpeMental extends TipoArma {
    private int id;

    public GolpeMental() {
        this.setNombre("Golpe Mental");
        this.setAtaque(15);
        this.setDefensa(5);
        this.setMagia(15);
        this.setPrecio(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
