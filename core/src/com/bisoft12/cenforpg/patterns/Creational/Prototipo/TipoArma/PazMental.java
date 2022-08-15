package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class PazMental extends TipoArma {

    private int id;

    public PazMental() {
        this.setNombre("Paz Mental");
        this.setAtaque(0);
        this.setDefensa(15);
        this.setMagia(15);
        this.setPrecio(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
