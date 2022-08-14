package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class Ciclon extends TipoArma {
    private int id;

    public Ciclon(){
        this.setNombre("Ciclon");
        this.setAtaque(0);
        this.setDefensa(0);
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
