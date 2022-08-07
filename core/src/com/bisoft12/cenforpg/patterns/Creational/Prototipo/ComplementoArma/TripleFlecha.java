package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class TripleFlecha extends TipoArma {
    private int id;

    public TripleFlecha() {
        this.setNombre("Triple Flecha");
        this.setPrecio(250);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
