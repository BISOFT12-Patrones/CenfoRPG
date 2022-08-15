package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class ClaridadMental extends TipoArma {

    private int id;

    public ClaridadMental() {
        this.setNombre("Claridad Mental");
        this.setAtaque(40);
        this.setDefensa(35);
        this.setMagia(55);
        this.setPrecio(300);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
