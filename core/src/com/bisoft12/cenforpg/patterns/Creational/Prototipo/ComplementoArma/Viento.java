package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class Viento extends TipoArma {
    private int id;

    public Viento() {
        this.setNombre("Viento");
        this.setPrecio(350);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
