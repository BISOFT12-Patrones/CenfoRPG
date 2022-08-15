package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class DobleFlecha extends TipoArma {
    private int id;

    public DobleFlecha() {
        this.setNombre("Doble Flecha");
        this.setAtaque(25);
        this.setDefensa(10);
        this.setMagia(0);
        this.setPrecio(50);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
