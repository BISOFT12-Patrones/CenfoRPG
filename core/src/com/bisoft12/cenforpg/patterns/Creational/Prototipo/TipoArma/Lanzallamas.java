package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class Lanzallamas extends TipoArma {
    private int id;

    public Lanzallamas() {
        this.setNombre("Lanza llamas");
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
