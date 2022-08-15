package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class HachaHierro extends TipoArma {
    private int id;

    public HachaHierro() {
        this.setNombre("Hacha de Hierro");
        this.setAtaque(60);
        this.setDefensa(25);
        this.setMagia(0);
        this.setPrecio(150);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
