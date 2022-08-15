package com.bisoft12.cenforpg.patterns.Creational.Prototipo.TipoArma;

public class EspadaPlata extends TipoArma {
    private int id;

    public EspadaPlata() {
        this.setNombre("Espada de Plata");
        this.setAtaque(25);
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
