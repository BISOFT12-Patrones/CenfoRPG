package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class Ciclon extends TipoArma {
    private int id;

    public Ciclon(){
        this.setNombre("Ciclon");
        this.setAtaque(65);
        this.setDefensa(30);
        this.setMagia(40);
        this.setPrecio(200);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
