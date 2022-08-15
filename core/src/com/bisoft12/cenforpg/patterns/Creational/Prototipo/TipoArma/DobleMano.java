package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class DobleMano extends TipoArma {
    private int id;

    public DobleMano() {
        this.setNombre("Doble Mano");
        this.setAtaque(40);
        this.setMagia(0);
        this.setDefensa(10);
        this.setPrecio(50);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
