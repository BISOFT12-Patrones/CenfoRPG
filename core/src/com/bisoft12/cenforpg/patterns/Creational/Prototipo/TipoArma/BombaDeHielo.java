package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class BombaDeHielo extends TipoArma {
    private int id;

    public BombaDeHielo() {
        this.setNombre("Bomba de hielo");
        this.setAtaque(60);
        this.setDefensa(45);
        this.setMagia(60);
        this.setPrecio(400);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
