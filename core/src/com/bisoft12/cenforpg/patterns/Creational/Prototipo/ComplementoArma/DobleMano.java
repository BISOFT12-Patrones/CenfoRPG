package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class DobleMano extends TipoArma {
    private int id;

    public DobleMano() {
        this.setNombre("Doble Mano");
        this.setPrecio(250);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
