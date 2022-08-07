package com.bisoft12.cenforpg.patterns.Creational.Prototipo.ComplementoArma;

public class DobleFlecha extends TipoArma {
    private int id;
    public DobleFlecha() {
        this.setNombre("Doble Flecha");
        this.setPrecio(200);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
