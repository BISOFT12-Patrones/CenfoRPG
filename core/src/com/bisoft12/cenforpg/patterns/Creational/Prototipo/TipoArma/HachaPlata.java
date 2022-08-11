package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class HachaPlata extends TipoArma {
    private int id;

    public HachaPlata(){
        this.setNombre("Hacha de Plata");
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
