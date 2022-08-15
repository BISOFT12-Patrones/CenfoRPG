package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class TripleFlecha extends TipoArma {
    private int id;

    public TripleFlecha() {
        this.setNombre("Triple Flecha");
        this.setAtaque(40);
        this.setDefensa(15);
        this.setMagia(0);
        this.setPrecio(100);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
