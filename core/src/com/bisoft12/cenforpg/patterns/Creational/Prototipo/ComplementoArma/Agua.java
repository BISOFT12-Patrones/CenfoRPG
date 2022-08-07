package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class Agua extends TipoArma {
    private int id;

    public Agua() {
        this.setNombre("Agua");
        this.setPrecio(300);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
