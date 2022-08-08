package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class Fuego extends TipoArma {

    private int id;

    public Fuego() {
        this.setNombre("Fuego");
        this.setPrecio(500);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
