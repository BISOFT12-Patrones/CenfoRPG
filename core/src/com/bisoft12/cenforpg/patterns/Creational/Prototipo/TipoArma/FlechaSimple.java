package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class FlechaSimple extends TipoArma {
    private int id;

    public FlechaSimple() {
        this.setNombre("Flecha Simple");
        this.setAtaque(15);
        this.setDefensa(5);
        this.setMagia(0);
        this.setPrecio(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
