package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class Hierro extends TipoArma {
    private int id;

    public Hierro() {
        this.setNombre("Hierro");
        this.setPrecio(200);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
