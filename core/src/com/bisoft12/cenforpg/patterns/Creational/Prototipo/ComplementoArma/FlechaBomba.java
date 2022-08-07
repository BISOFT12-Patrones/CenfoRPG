package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class FlechaBomba extends TipoArma {
    private int id;

    public FlechaBomba() {
        this.setNombre("Flecha Bomba");
        this.setPrecio(300);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

