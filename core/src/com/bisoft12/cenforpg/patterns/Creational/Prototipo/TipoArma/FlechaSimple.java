package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class FlechaSimple extends TipoArma {
    private int id;

    public FlechaSimple() {
        this.setNombre("Flecha Simple");
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
