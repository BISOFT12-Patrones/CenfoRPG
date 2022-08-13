package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class DobleMano extends TipoArma {
    private int id;

    public DobleMano() {
        this.setNombre("Doble Mano");
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
