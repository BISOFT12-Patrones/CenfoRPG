package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class TripleFlecha extends TipoArma {
    private int id;

    public TripleFlecha() {
        this.setNombre("Triple Flecha");
        this.setPrecio(0);
        this.setAtaque(0);
        this.setMagia(0);
        this.setDefensa(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
