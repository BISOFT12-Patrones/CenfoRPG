package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class Oro extends TipoArma {

    private int id;

    public Oro() {
        this.setNombre("Oro");
        this.setPrecio(600);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
