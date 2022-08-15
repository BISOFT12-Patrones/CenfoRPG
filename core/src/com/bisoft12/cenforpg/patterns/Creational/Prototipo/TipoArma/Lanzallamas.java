package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class Lanzallamas extends TipoArma {
    private int id;

    public Lanzallamas() {
        this.setNombre("Lanza llamas");
        this.setAtaque(40);
        this.setDefensa(15);
        this.setMagia(25);
        this.setPrecio(100);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
