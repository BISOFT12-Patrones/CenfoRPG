package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class Plata extends TipoArma {
    private int id;

    public Plata() {
        this.setNombre("Plata");
        this.setPrecio(250);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
